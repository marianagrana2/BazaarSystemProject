
package com.example.BazaarSystemProject.repository;

import com.example.BazaarSystemProject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long>{
    
}
