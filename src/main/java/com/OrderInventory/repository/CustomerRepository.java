package com.OrderInventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OrderInventory.entity.Customers;



@Repository

public interface CustomerRepository extends JpaRepository<Customers, Integer> {
	
}