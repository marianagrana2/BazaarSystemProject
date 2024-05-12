
package com.example.BazaarSystemProject.service;

import com.example.BazaarSystemProject.model.Client;
import java.util.List;


public interface IClientService {
    
    public List<Client> getClients();
    
    public void saveClient(Client cli);
    
    public void deleteClient(Long id);
    
    public Client findClient(Long id);
    
    public void editClient(Long client_id_original,Long client_id_new,String first_name_new,String last_name_new,String dni_new);
    
}
