package com.OrderInventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.OrderInventory.entity.Products;

@Repository

public interface ProductsRepository extends JpaRepository<Products, Integer> {
	
}
