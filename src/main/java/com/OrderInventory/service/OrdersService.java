package com.OrderInventory.service;

import java.util.List;

import com.OrderInventory.dto.OrderStatusCountDto;
import com.OrderInventory.dto.OrdersDto;
import com.OrderInventory.entity.Orders;
import com.OrderInventory.exception.ResourceNotFoundException;

import jakarta.validation.Valid;

public interface OrdersService {
    List<Orders> fetchAllOrders();

	//List<Orders> getOrdersByStatus(String orderstatus);
	
	Orders updateOrder(int orderId, Orders updatedOrder);

	
	//void deleteOrderById(int orderId);
	public String deleteOrdersById(@Valid int ordersId);
	
	
	void createOrder(Orders newOrder);

	void deleteOrderById(int ordersId);
	
	List<OrdersDto> getOrdersByStoreName(String store) throws ResourceNotFoundException;

	List<OrderStatusCountDto> getOrderStatusCount();


	
	
	


	
	
	

	
}
