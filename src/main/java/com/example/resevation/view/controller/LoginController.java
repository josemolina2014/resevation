package com.example.resevation.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * En este controlador se validará dos peticiones la de login y la home a través de la ruta /app/login y /app/home respectivamente.
 */
@Controller
@RequestMapping("app")
public class LoginController {

    @GetMapping(value = {"/login", "/"}) //captura la pagina inicial
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        String errorMessage= "Usuario no autorizado, debe autenticarse";
        modelAndView.addObject("erroMsg",errorMessage);
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        return mav;
    }

}
