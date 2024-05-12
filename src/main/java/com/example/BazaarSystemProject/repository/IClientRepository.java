package com.example.BazaarSystemProject.repository;

import com.example.BazaarSystemProject.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<Client,Long>{
    
}
