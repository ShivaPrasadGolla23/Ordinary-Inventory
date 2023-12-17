package com.OrderInventory.controller;

import java.util.List;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.OrderInventory.entity.Orders;
import com.OrderInventory.service.OrdersService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.persistence.criteria.Order;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {
	
	@Autowired
	private OrdersService ordersService;
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List<Orders>>displayAllInventory() {
		List<Orders>ordersList=ordersService.fetchAllOrders();
	      return new ResponseEntity<List<Orders>>(ordersList,HttpStatus.OK);
	      
	}
	
	@GetMapping("/status/{orderStatus}")
    public ResponseEntity<List<Orders>> getOrdersByStatus(@PathVariable String orderStatus) {
        List<Orders> ordersList = ordersService.getOrdersByStatus(orderStatus);
        return ResponseEntity.ok(ordersList);
    }
	
	@PutMapping("/{orders}")
    public Orders updateOrder(@PathVariable("orders") int orderId, @RequestBody Orders updatedOrder) {
        return ordersService.updateOrder(orderId, updatedOrder);
    }
	
	 @DeleteMapping("/{orderId}")
	    public ResponseEntity<String> deleteOrder(@PathVariable int orderId) {
	        ordersService.deleteOrderById(orderId);
	        return new ResponseEntity<>("Record deleted Successfully", HttpStatus.OK);
	    }
	
	 @PostMapping("{createorder}")
	    public ResponseEntity<String> createOrder(@RequestBody Orders newOrder) {
	        ordersService.createOrder(newOrder);
	        return new ResponseEntity<>("Record Created Successfully", HttpStatus.OK);
	    }
		 
	 
} 
