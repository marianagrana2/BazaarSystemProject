
package com.example.BazaarSystemProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long product_code;
    private String product_name;
    private String product_brand;
    private double price;
    public double available_amount;

    @ManyToOne
    @JoinColumn(name="sale_code")
    @JsonIgnore       
    Sale sal;
    
    public Product() {
    }

    public Product(Long product_code, String product_name, String product_brand, double price, double available_amount) {
        this.product_code = product_code;
        this.product_name = product_name;
        this.product_brand = product_brand;
        this.price = price;
        this.available_amount = available_amount;
    }
  
}
