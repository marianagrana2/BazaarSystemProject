
package com.example.BazaarSystemProject.service;

import com.example.BazaarSystemProject.model.Product;
import com.example.BazaarSystemProject.repository.IProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository productRepo;
    
    @Override
    public List<Product> getProducts() {
        List<Product> listProducts = productRepo.findAll();
        return listProducts;   
    }

    @Override
    public void saveProduct(Product pro) {
        productRepo.save(pro);
    }

    @Override
    public void deleteProduct(Long id) {
         productRepo.deleteById(id);
    }

    @Override
    public Product findProduct(Long id) {
       Product pro = productRepo.findById(id).orElse(null);
       return pro;
    }

    @Override
    public void editProduct(Long product_code_original, Long product_code_new, String product_name_new, String product_brand_new, double price_new, double available_amount_new) {
        Product pro = this.findProduct(product_code_original);
        
        pro.setProduct_code(product_code_new);
        pro.setProduct_name(product_name_new);
        pro.setProduct_brand(product_brand_new);
        pro.setPrice(price_new);
        pro.setAvailable_amount(available_amount_new);
        
        this.saveProduct(pro);
    }

    @Override
    public List<Product> getProductsLackStock() {
        List<Product> listProducts = productRepo.findAll();
        //available_amount less than 5
        List<Product>listProductsLackStock = new ArrayList<Product>();
        for(Product pro: listProducts){
            if(pro.available_amount < 5){
                listProductsLackStock.add(pro);
            }
        }
            
        return listProductsLackStock;
    }
    
}
