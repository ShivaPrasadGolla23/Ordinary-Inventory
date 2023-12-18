package com.OrderInventory.service;

import java.util.List;

import com.OrderInventory.dto.InventoryDto;
import com.OrderInventory.exception.ResourceNotFoundException;

public interface InventoryService {
	
	List<InventoryDto> getInventoryByStoreId(int storeId) throws ResourceNotFoundException;

	

}