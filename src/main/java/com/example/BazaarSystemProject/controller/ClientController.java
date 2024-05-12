
package com.example.BazaarSystemProject.controller;

import com.example.BazaarSystemProject.model.Client;
import com.example.BazaarSystemProject.service.IClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    
    @Autowired
    private IClientService clientServ;
    
    @GetMapping("/clients")
    public List<Client> getClients(){
        return clientServ.getClients();
    }
    
    
    @GetMapping("/clients/{client_id}")
    public Client findClient(@PathVariable Long client_id){
        Client foundClient = clientServ.findClient(client_id);
        if(foundClient ==null){
            return null;
        } 
        return foundClient;
    }
    
    @PostMapping("/clients/create")
    public String saveClient(@RequestBody Client cli){
        clientServ.saveClient(cli);
        return "Client successfully created.";
    }
    
    @DeleteMapping("/clients/delete/{client_id}")
    public String deleteClient(@PathVariable Long client_id){
        clientServ.deleteClient(client_id);
        return "Client successfully deleted.";
    }
    
    @PutMapping("/clients/edit/{client_id_original}")
    public Client editClient(@PathVariable Long client_id_original,
                             @RequestParam(required=false,name="client_id")Long client_id_new,
                             @RequestParam(required=false,name="first_name")String first_name_new,
                             @RequestParam(required=false,name="last_name")String last_name_new,
                             @RequestParam(required=false,name="dni")String dni_new
                             ){
        clientServ.editClient(client_id_original, client_id_new, first_name_new, last_name_new, dni_new);
        
        Client cli =clientServ.findClient(client_id_new);
        return cli;
    }
    
}
