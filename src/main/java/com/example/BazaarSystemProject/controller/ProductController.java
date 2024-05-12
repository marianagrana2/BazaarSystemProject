
package com.example.BazaarSystemProject.controller;


import com.example.BazaarSystemProject.model.Product;
import com.example.BazaarSystemProject.service.IProductService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    
    @Autowired
    private IProductService productServ;
    
    @GetMapping("/products")
    public List<Product> getProducts(){
        return productServ.getProducts();
    }
    
    @GetMapping("/products/{product_code}")
    public Product findProduct(@PathVariable Long product_code){
        Product foundProduct = productServ.findProduct(product_code);
        if(foundProduct ==null){
            return null;
        } 
        return foundProduct;
    }
    
    
    @PostMapping("/products/create")
    public String saveClient(@RequestBody Product pro){
        productServ.saveProduct(pro);
        return "Product successfully created.";
    }
    
    @DeleteMapping("/products/delete/{product_code}")
    public String deleteProduct(@PathVariable Long product_code){
        productServ.deleteProduct(product_code);
        return "Product successfully deleted.";
    }
    
    @PutMapping("/products/edit/{product_code_original}")
    public Product editProduct(@PathVariable Long product_code_original,
                             @RequestParam(required=false,name="product_code")Long product_code_new,
                             @RequestParam(required=false,name="product_name")String product_name_new,
                             @RequestParam(required=false,name="brand")String product_brand_new,
                             @RequestParam(required=false,name="price")double price_new,
                             @RequestParam(required=false,name="available_amount")double available_amount_new
                             ){
       productServ.editProduct(product_code_original, product_code_new, product_name_new, product_brand_new,price_new,available_amount_new);
        
       Product pro =productServ.findProduct(product_code_new);
        return pro;
    }
    
    //Out of Stock
    @GetMapping("/products/lack_stock")
    public List<Product>getlistProductsLackStock(){
        return productServ.getProductsLackStock();
    }
    
}
