package com.OrderInventory.service;

import java.util.List;

import com.OrderInventory.entity.Orders;

import jakarta.validation.Valid;

public interface OrdersService {
    List<Orders> fetchAllOrders();

	List<Orders> getOrdersByStatus(String orderstatus);
	
	Orders updateOrder(int orderId, Orders updatedOrder);

	
	void deleteOrderById(int orderId);

	void createOrder(Orders newOrder);




	
	
	


	
	
	

	
}
