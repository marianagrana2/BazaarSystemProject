
package com.example.BazaarSystemProject.service;

import com.example.BazaarSystemProject.dto.SaleInfoDto;
import com.example.BazaarSystemProject.model.Sale;
import com.example.BazaarSystemProject.repository.ISaleRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService implements ISaleService {
    
    @Autowired
    private ISaleRepository saleRepo;

    @Override
    public List<Sale> getSales() {
       List<Sale>listSales = saleRepo.findAll();
       return listSales;
    }

    @Override
    public void saveSale(Sale sal) {
        saleRepo.save(sal);
    }

    @Override
    public void deleteSale(Long id) {
        saleRepo.deleteById(id);
    }

    @Override
    public Sale findSale(Long id) {
         Sale sal = saleRepo.findById(id).orElse(null);
         return sal;
    }

    @Override
    public void editSale(Sale sal) {
        this.saveSale(sal);
    }

    @Override
    public List<SaleInfoDto> getBestSelling() {
        List<Sale> listSales = this.getSales();
        List<Sale> listBestSales = new ArrayList<Sale>();
        List<SaleInfoDto> listBestSalesDto = new ArrayList<SaleInfoDto>();
        double totalMax = Double.NEGATIVE_INFINITY;
        
        for(Sale sale:listSales){
            double total = sale.getTotal();
            if(total > totalMax){
                totalMax = total;
                listBestSales.clear();
                listBestSales.add(sale);
            } else if(total == totalMax){
                listBestSales.add(sale);
            }
        }
        
        for(Sale sale: listBestSales){
            SaleInfoDto saleInfoDto = new SaleInfoDto();
            saleInfoDto.setSale_code(sale.getSale_code());
            saleInfoDto.setListProducts(sale.getListProducts());
            saleInfoDto.setTotal(sale.getTotal());
            saleInfoDto.setFirst_name(sale.getAClient().getFirst_name());
            saleInfoDto.setLast_name(sale.getAClient().getLast_name());
            
            listBestSalesDto.add(saleInfoDto);
        }
        return listBestSalesDto;
        
    }

    @Override
    public List<Sale> getSalesPerDay(LocalDate dateSaleConsult) {
        List<Sale> listSales = this.getSales();
        List<Sale> listSalesPerDay = new ArrayList<>();
        
        for(Sale sale:listSales){
            LocalDate saleDate = sale.getSale_date();
            if(saleDate.equals(dateSaleConsult)){
             listSalesPerDay.add(sale);
            }
        }
        return listSalesPerDay;
        
    }
    
}
