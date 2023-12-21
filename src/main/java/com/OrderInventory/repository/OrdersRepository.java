package com.OrderInventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.OrderInventory.entity.Orders;

@Repository

public interface OrdersRepository extends JpaRepository<Orders, Integer> {



    List<Orders> deleteByOrderId(int orderId);

    @Query(nativeQuery = true, 
			value = "SELECT order_status, COUNT(customer_id) as customerCount FROM orders GROUP BY order_status")
	List<Object[]> getOrderStatusCount();
	
	List<Orders> findByStoreId_StoreName(String store);

	

	List<Orders> findByStoreId_StoreId(int storeId);

	

	

	
}