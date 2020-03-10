package com.example.resevation.business.interfaces;

import com.example.resevation.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, String> {


    /**
     * definción de metodo para buscar por apellido
     * @param lastName
     * @return lista de clientes con el apellido indicado
     */
    public List<Client> findByLastName(String lastName);

    public Client findByIdentification(String identification);
}
