package com.ngibliant.springbootcrudexample.repository;

import com.ngibliant.springbootcrudexample.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

	Product findByName(String name);

}
