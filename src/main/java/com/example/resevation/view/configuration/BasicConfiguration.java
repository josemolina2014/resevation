package com.example.resevation.view.configuration;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().anyRequest().authenticated()//autorizar las peticiones autenticadas
                .and()
                .formLogin().loginPage("/app/login").permitAll()//pagina del login publica
                    .failureUrl("/app/login?error=true")//mensaje de error cuando falla la autenticación
                    .defaultSuccessUrl("/app/home");//main
    }

    /**
     * Configurar el método de autentificación, para lo cual utilizamos un método en memoria.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(encoder.encode("demo"))
                .roles("USER");
    }
    /**
     * Configurar qué rutas de la aplicación se deben excluir del proceso de login,
     * en la cual están todos los recursos estáticos configurados anteriormente.
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**",
                        "/static/**",
                        "/css/**",
                        "/js/**",
                        "/images/**");
    }
}
