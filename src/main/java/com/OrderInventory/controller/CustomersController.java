package com.OrderInventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OrderInventory.dto.CustomerInputDto;
import com.OrderInventory.dto.CustomerOutputDto;
import com.OrderInventory.entity.Customers;
import com.OrderInventory.exception.ResourceNotFoundException;
import com.OrderInventory.service.CustomersService;

@RestController
@Validated
@CrossOrigin(origins = "http://localhost:3000")
public class CustomersController {
	
	@Autowired
	CustomersService customersService;

	
	@PostMapping("/customers/addCustomerDto")
	public ResponseEntity<CustomerOutputDto> addCustomerDto(CustomerInputDto customerInputDto) {
		
		CustomerOutputDto addCustomerDto = customersService.addCustomerDto(customerInputDto);
		
		return new ResponseEntity<CustomerOutputDto>(addCustomerDto,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/customers/updateDto")
	public ResponseEntity<Customers> updateCustomerDto(CustomerInputDto customerInputDto) throws ResourceNotFoundException{
		
		Customers updatedCustomer= customersService.updateCustomerDto(customerInputDto);
		
		return new ResponseEntity<Customers>(updatedCustomer,HttpStatus.OK);
		
		
	}
	
	

}

