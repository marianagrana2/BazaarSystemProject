
package com.example.BazaarSystemProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long sale_code;
    private LocalDate sale_date;
    private double total;
      
    @OneToMany(mappedBy="sal")
    private List<Product> listProducts;
    
    @OneToOne
    @JoinColumn(name="client_id",referencedColumnName="client_id")
    private Client aClient;

    public Sale() {
    }

    public Sale(Long sale_code, LocalDate sale_date, double total, List<Product> listProducts, Client aClient) {
        this.sale_code = sale_code;
        this.sale_date = sale_date;
        this.total = total;
        this.listProducts = listProducts;
        this.aClient = aClient;
    }

}
