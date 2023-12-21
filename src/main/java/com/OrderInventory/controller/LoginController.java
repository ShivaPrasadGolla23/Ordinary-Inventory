package com.OrderInventory.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.OrderInventory.dto.LoginInputDto;
import com.OrderInventory.dto.LoginOutputDto;
import com.OrderInventory.exception.InvalidCredentialsException;
import com.OrderInventory.exception.ResourceNotFoundException;
import com.OrderInventory.service.LoginService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/customers/login")
	public ResponseEntity<LoginOutputDto> customerLogin(@RequestBody LoginInputDto loginInputDto) throws InvalidCredentialsException,ResourceNotFoundException {
		
		LoginOutputDto loginOutputDto = loginService.customerLogin(loginInputDto);
		
		return new ResponseEntity<LoginOutputDto>(loginOutputDto,HttpStatus.OK);
	}

	
	
}
