
package com.example.BazaarSystemProject.service;

import com.example.BazaarSystemProject.dto.SaleInfoDto;
import com.example.BazaarSystemProject.model.Sale;
import java.time.LocalDate;
import java.util.List;


public interface ISaleService {
    
    public List<Sale> getSales();
    
    public void saveSale(Sale sal);
    
    public void deleteSale(Long id);
    
    public Sale findSale(Long id);
    
    public void editSale(Sale sal);
    
    public List<SaleInfoDto>getBestSelling();
    
    public List<Sale> getSalesPerDay(LocalDate dateSaleConsult);
    
}
