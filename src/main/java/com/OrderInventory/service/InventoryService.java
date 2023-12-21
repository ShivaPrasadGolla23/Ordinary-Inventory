package com.OrderInventory.service;


import com.OrderInventory.dto.InventoryDetailsDto;
import com.OrderInventory.dto.InventoryDto;
import com.OrderInventory.dto.InventoryShipmentCountDto;
import com.OrderInventory.dto.InventoryShipmentCountResponse;
import com.OrderInventory.dto.InventoryShipmentDto;
import com.OrderInventory.entity.Inventory;
import com.OrderInventory.exception.ResourceNotFoundException;

import java.util.List;

public interface InventoryService {

    List<InventoryDto> getInventoryByStoreId(int storeId) throws ResourceNotFoundException;

	
    Inventory getAllProductAndStoreDetails(int inventoryId) throws ResourceNotFoundException;
    
    List<InventoryShipmentDto> getInventoriesAndMatchingShipments() throws ResourceNotFoundException;

    List<InventoryShipmentCountDto> getShipmentStatusCount() throws ResourceNotFoundException;


	
	
    }
