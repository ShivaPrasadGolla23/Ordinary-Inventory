package com.OrderInventory.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OrderInventory.dto.LoginInputDto;
import com.OrderInventory.dto.LoginOutputDto;
import com.OrderInventory.entity.Login;
import com.OrderInventory.exception.InvalidCredentialsException;
import com.OrderInventory.exception.ResourceNotFoundException;
import com.OrderInventory.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginRepository loginRepository;

	@Override
	public LoginOutputDto customerLogin(LoginInputDto loginInputDto) throws InvalidCredentialsException,ResourceNotFoundException {
		
		Optional<Login> optionalList=loginRepository.findById(loginInputDto.getEmail());
		
		if(optionalList.isPresent()) {
			
			Login login = optionalList.get();
			
			if(loginInputDto.getPassword().equals(login.getPassword()) && loginInputDto.getCategory().equals(login.getCategory())) {
				
				login.setLogin(true);
				
				Login newLogin = loginRepository.save(login);
				
				LoginOutputDto loginOutputDto = new LoginOutputDto();
				
				loginOutputDto.setEmail(newLogin.getEmail());
				loginOutputDto.setCategory(newLogin.getCategory());
				loginOutputDto.setLogin(newLogin.isLogin());
				
				return loginOutputDto;
				
			}
			else {
				throw new InvalidCredentialsException("Invalid email/Password, try again");
			}
		}
		else {
			
			throw new ResourceNotFoundException("No Customer found with email: "+loginInputDto.getEmail());
		}		
		
	}	

}