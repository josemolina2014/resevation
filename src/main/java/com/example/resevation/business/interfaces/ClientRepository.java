package com.example.resevation.business.interfaces;

import com.example.resevation.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, String> {

    /**
     * defincion de metodo para buscar por apellido
     * @param cliLastName
     * @return
     */
    public List<Client> findByLastName(String lastName);

    public Client findByIdentification(String identification);
}
