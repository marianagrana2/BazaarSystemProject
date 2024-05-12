
package com.example.BazaarSystemProject.controller;


import com.example.BazaarSystemProject.dto.SaleInfoDto;
import com.example.BazaarSystemProject.model.Sale;
import com.example.BazaarSystemProject.service.ISaleService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaleController {
    
    @Autowired
    private ISaleService saleServ;
    
    @GetMapping("/sales")
    public List<Sale> getSales(){
        return saleServ.getSales();
    }
    
    @GetMapping("/sales/{sale_code}")
    public Sale findSale(@PathVariable Long sale_code){
        Sale foundSale = saleServ.findSale(sale_code);
        if(foundSale ==null){
            return null;
        } 
        return foundSale;
    }
    
    
    @PostMapping("/sales/create")
    public String saveSale(@RequestBody Sale sal){
       saleServ.saveSale(sal);
        return "Sale successfully created.";
    }
    
    @DeleteMapping("/sales/delete/{sale_code}")
    public String deleteSale(@PathVariable Long sale_code){
        saleServ.deleteSale(sale_code);
        return "Product successfully deleted.";
    }
    
     @PutMapping("/sales/edit")
    public Sale editSale(@RequestBody Sale sal){
        saleServ.editSale(sal);
        
        return saleServ.findSale(sal.getSale_code());
    }
    
   
    @GetMapping("/sales/bestselling")
    public List<SaleInfoDto> getBestSelling(){
        return saleServ.getBestSelling();
    }
    
    @GetMapping("/salesperdate")
    public List<Sale> getSalesPerDay(@RequestParam("date") 
                                    @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        return saleServ.getSalesPerDay(date);
    }
   
}
