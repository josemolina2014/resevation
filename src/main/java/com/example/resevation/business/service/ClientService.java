package com.example.resevation.business.service;

import com.example.resevation.business.interfaces.ClientRepository;
import com.example.resevation.model.Client;

import java.util.List;

public class ClientService
{
    private final ClientRepository clientRepository;

    /**
     *
     * @param clientRepository
     */
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * Creación de cliente en la base de datos
     * @param client Cliente
     * @return Cliente creado
     */
    public Client create (Client client){
        return this.clientRepository.save(client);
    }

    /**
     * Actualizar cliente
     * @param client
     * @return
     */
    public Client update(Client client){
        return this.clientRepository.save(client);
    }

    /**
     * Eliminar un cliente
     * @param client
     */
    public void delete(Client client){
        this.clientRepository.delete(client);
    }

    /**
     * Buscar todos
     * @return
     */
    public List<Client> findAll(){
        return this.clientRepository.findAll();
    }

    /**
     * Busqueda por identificacion
     * @param id
     * @return
     */
    public Client findByIdentification(String id){
        return this.clientRepository.findByIdentification(id);
    }

    /**
     * Busqueda por apellido
     * @param lastName
     * @return
     */
    public List<Client> findByLastNAme(String lastName){
        return this.clientRepository.findByLastName(lastName);
    }

}
