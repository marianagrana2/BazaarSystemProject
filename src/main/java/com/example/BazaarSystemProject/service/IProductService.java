
package com.example.BazaarSystemProject.service;

import com.example.BazaarSystemProject.model.Product;
import java.util.List;

public interface IProductService {
    
    public List<Product> getProducts();
    
    public void saveProduct(Product pro);
    
    public void deleteProduct(Long id);
    
    public Product findProduct(Long id);
    
    public void editProduct(Long product_code_original,Long product_code_new,String product_name_new,
                            String product_brand_new,double price_new,double available_amount_new);
    
    public List<Product>getProductsLackStock();
}
