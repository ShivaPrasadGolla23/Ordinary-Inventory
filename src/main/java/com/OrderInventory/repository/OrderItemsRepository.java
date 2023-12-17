package com.OrderInventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OrderInventory.entity.OrderItems;

@Repository

public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer> {
	
}