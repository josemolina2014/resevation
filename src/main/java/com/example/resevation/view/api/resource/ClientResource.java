package com.example.resevation.view.api.resource;

import com.example.resevation.business.service.ClientService;
import com.example.resevation.model.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
public class ClientResource {

    private final ClientService clientService;
    public ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        return ResponseEntity.ok(this.clientService.findAll());
    }
}
