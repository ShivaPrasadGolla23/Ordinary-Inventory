package com.OrderInventory.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OrderInventory.dto.CustomerInputDto;
import com.OrderInventory.dto.CustomerOutputDto;
import com.OrderInventory.entity.Customers;
import com.OrderInventory.entity.Login;
import com.OrderInventory.exception.ResourceNotFoundException;
import com.OrderInventory.repository.CustomersRepository;

@Service
public class CustomersServiceImpl implements CustomersService{
	
	@Autowired
	CustomersRepository customersRepository;
	
	
	@Override
	public CustomerOutputDto addCustomerDto(CustomerInputDto customerIputDto) {
		
		//create customer instance
		
		Customers customers = new Customers();
		
		customers.setEmailAddress(customerIputDto.getEmailAddress());
		customers.setFullName(customerIputDto.getFullName());
		
		// create login instance
		
		Login login = new Login();
		
		login.setEmail(customerIputDto.getEmailAddress());
		login.setPassword(customerIputDto.getPassword());
		login.setCategory("customer");
		login.setLogin(false);
		
		customers.setLogin(login);
		
		Customers newCustomer = customersRepository.save(customers);
		
		CustomerOutputDto customerOutputDto = new CustomerOutputDto();
		
		customerOutputDto.setEmailAddress(newCustomer.getEmailAddress());
		customerOutputDto.setFullName(newCustomer.getFullName());
		
		return customerOutputDto;
	}

	@Override
	public Customers updateCustomerDto(CustomerInputDto customerIputDto) throws ResourceNotFoundException {
		
		Optional<Customers> optionalList= customersRepository.findById(customerIputDto.getCustomerId());
		
		if (optionalList.isPresent()) {
			
			Customers customer = optionalList.get();
			
			customer.setCustomerId(customerIputDto.getCustomerId());
			customer.setEmailAddress(customerIputDto.getEmailAddress());
			customer.setFullName(customerIputDto.getFullName());
			
			Login login = new Login();
			
			login.setEmail(customerIputDto.getEmailAddress());
			login.setPassword(customerIputDto.getPassword());
			login.setCategory("customer");
			
			customer.setLogin(login);
			
			Customers updatedCustomer = customersRepository.save(customer);
			
			return updatedCustomer;			
			
		}
		else {
			
			throw new ResourceNotFoundException("No Customer found with Id: "+customerIputDto.getCustomerId());
		}

	}
	
	

}