package com.OrderInventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.OrderInventory.dto.InventoryDto;
import com.OrderInventory.exception.ResourceNotFoundException;
import com.OrderInventory.service.InventoryService;

@RestController
	public class InventoryController {
		
		@Autowired
		InventoryService inventoryService;
		
		@GetMapping("/api/v1/inventory/{storeId}")
		public ResponseEntity<List<InventoryDto>> getInventoryByStoreId(@PathVariable int storeId) throws ResourceNotFoundException {
			
			List<InventoryDto> inventoryByStoreId = inventoryService.getInventoryByStoreId(storeId);
			
			return new ResponseEntity<List<InventoryDto>>(inventoryByStoreId,HttpStatus.OK);
			
			
		}
		
		

	}
