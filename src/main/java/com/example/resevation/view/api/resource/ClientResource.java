package com.example.resevation.view.api.resource;

import com.example.resevation.business.service.ClientService;
import com.example.resevation.model.Client;
import com.example.resevation.view.vo.ClientVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/{identification}")
    public ResponseEntity<Client> createClient(@RequestBody ClientVO clientVo){
        Client client = new Client();
        client.setName(clientVo.getName());
        client.setLastName(clientVo.getLastName());
        client.setAddress(clientVo.getAddress());
        client.setEmail(clientVo.getEmail());
        client.setPhone(clientVo.getPhone());
        client.setIdentification(clientVo.getIdentification());

        return new ResponseEntity<>(this.clientService.create(client), HttpStatus.CREATED);

    }
    @PutMapping("/{identification}")
    public ResponseEntity<Client> updateClient(
                                                @PathVariable ("identification") String identification,
                                                @RequestBody ClientVO clientVo)
    {
        Client client = clientService.findByIdentification(identification);
        if(client == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            client.setName(clientVo.getName());
            client.setLastName(clientVo.getLastName());
            client.setAddress(clientVo.getAddress());
            client.setEmail(clientVo.getEmail());
            client.setPhone(clientVo.getPhone());
        }
        return new ResponseEntity<>(this.clientService.update(client), HttpStatus.OK);
    }

    @DeleteMapping("/{identification}")
    public void deleteClient(@PathVariable("identification") String identification){
        Client client = clientService.findByIdentification(identification);
        if(client != null)
        {
            this.clientService.delete(client);
        }
    }

    @GetMapping("/{identification}")
    public ResponseEntity<Client> getClientById(@PathVariable("identification") String identification){
        Client client = this.clientService.findByIdentification(identification);
        if(client==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(client, HttpStatus.OK);
    }


}
