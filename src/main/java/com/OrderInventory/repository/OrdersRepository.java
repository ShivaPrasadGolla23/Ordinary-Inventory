package com.OrderInventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.OrderInventory.entity.Orders;

@Repository

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

	List<Orders> findByOrderStatus(String orderstatus);




	

	

	
}