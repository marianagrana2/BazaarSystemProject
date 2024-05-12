
package com.example.BazaarSystemProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long client_id;
    private String first_name;
    private String last_name;
    private String dni;

    public Client() {
    }

    public Client(Long client_id, String first_name, String last_name, String dni) {
        this.client_id = client_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.dni = dni;
    }
    
    
}
