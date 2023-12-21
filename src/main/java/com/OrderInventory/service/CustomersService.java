package com.OrderInventory.service;

import com.OrderInventory.dto.CustomerInputDto;
import com.OrderInventory.dto.CustomerOutputDto;
import com.OrderInventory.entity.Customers;
import com.OrderInventory.exception.ResourceNotFoundException;

public interface CustomersService {
	
	
	CustomerOutputDto addCustomerDto(CustomerInputDto customerIputDto);
	Customers updateCustomerDto(CustomerInputDto customerIputDto) throws ResourceNotFoundException;

}