
package com.example.BazaarSystemProject.service;

import com.example.BazaarSystemProject.model.Client;
import com.example.BazaarSystemProject.repository.IClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements IClientService{

    @Autowired
    private IClientRepository clientRepo;
    
    @Override
    public List<Client> getClients() {
       List<Client>listClients = clientRepo.findAll();
       return listClients;
    }

    @Override
    public void saveClient(Client cli) {
        clientRepo.save(cli);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepo.deleteById(id);
    }

    @Override
    public Client findClient(Long id) {
         Client cli = clientRepo.findById(id).orElse(null);
         return cli;
    }

    @Override
    public void editClient(Long client_id_original, Long client_id_new, String first_name_new, String last_name_new, String dni_new) {
       Client cli = this.findClient(client_id_original);
       
       cli.setClient_id(client_id_new);
       cli.setFirst_name(first_name_new);
       cli.setLast_name(last_name_new);
       cli.setDni(dni_new);
       
       this.saveClient(cli);
    }
    
}
