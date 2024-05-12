package com.example.BazaarSystemProject.dto;

import com.example.BazaarSystemProject.model.Product;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SaleInfoDto {
    
    private Long sale_code;
    private double total;
    private List<Product> listProducts;
    private String first_name;
    private String last_name;

    public SaleInfoDto() {
    }

    public SaleInfoDto(Long sale_code, double total, List<Product> listProducts, String first_name, String last_name) {
        this.sale_code = sale_code;
        this.total = total;
        this.listProducts = listProducts;
        this.first_name = first_name;
        this.last_name = last_name;
    }
    
    
}
