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

import com.OrderInventory.dto.OrderStatusCountDto;
import com.OrderInventory.dto.OrdersDto;
import com.OrderInventory.entity.Orders;
import com.OrderInventory.exception.ResourceNotFoundException;
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
    public ResponseEntity<List<Orders>> displayAllInventory() {
        try {
            List<Orders> ordersList = ordersService.fetchAllOrders();
            return new ResponseEntity<>(ordersList, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception or handle it as needed
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	
	
	
	@GetMapping("/api/v1/orders/status")
	public List<OrderStatusCountDto> getOrderStatusCount(){
		
		List<OrderStatusCountDto> result = ordersService.getOrderStatusCount();
		
		return result;
	}

	
	@PutMapping("/{orders}")
    public Orders updateOrder(@PathVariable("orders") int orderId, @RequestBody Orders updatedOrder) {
        return ordersService.updateOrder(orderId, updatedOrder);
    }
	
	
	@DeleteMapping("/delete/{orderid}")
	public ResponseEntity<String> deleteOrdersById(@Valid @PathVariable (value="orderid") int ordersId){
		return new ResponseEntity<String> ("Customer deleted with id : "+ordersId,HttpStatus.OK);
	}
	

	
	 @PostMapping("{createorder}")
	    public ResponseEntity<String> createOrder(@RequestBody Orders newOrder) {
	        ordersService.createOrder(newOrder);
	        return new ResponseEntity<>("Record Created Successfully", HttpStatus.OK);
	    }
		
	 @GetMapping("/api/v1/orders/{store}")
		public List<OrdersDto> getOrdersByStoreName(@PathVariable String store) throws ResourceNotFoundException{
			
			List<OrdersDto> ordersDto = ordersService.getOrdersByStoreName(store);
			
			return ordersDto;
			
		}
	
} 