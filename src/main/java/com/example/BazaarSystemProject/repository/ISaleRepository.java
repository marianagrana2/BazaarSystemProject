
package com.example.BazaarSystemProject.repository;

import com.example.BazaarSystemProject.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISaleRepository extends JpaRepository<Sale,Long>{
    
}
