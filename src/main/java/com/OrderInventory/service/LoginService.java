package com.OrderInventory.service;

import com.OrderInventory.dto.LoginInputDto;
import com.OrderInventory.dto.LoginOutputDto;
import com.OrderInventory.exception.InvalidCredentialsException;
import com.OrderInventory.exception.ResourceNotFoundException;

public interface LoginService {
	LoginOutputDto customerLogin(LoginInputDto loginInputDto) throws InvalidCredentialsException, ResourceNotFoundException;

}
