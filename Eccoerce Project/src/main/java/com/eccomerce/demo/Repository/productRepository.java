package com.eccomerce.demo.Repository;

import com.eccomerce.demo.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends JpaRepository<Product,Integer> {

}
