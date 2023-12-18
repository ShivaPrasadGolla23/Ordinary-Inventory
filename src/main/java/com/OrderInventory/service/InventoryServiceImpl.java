package com.OrderInventory.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OrderInventory.dto.InventoryDto;
import com.OrderInventory.entity.Inventory;
import com.OrderInventory.entity.Orders;
import com.OrderInventory.exception.ResourceNotFoundException;
import com.OrderInventory.repository.InventoryRepository;
import com.OrderInventory.repository.OrdersRepository;

@Service
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	InventoryRepository inventoryRepository;
	@Autowired
	OrdersRepository ordersRepository;

	@Override
	public List<InventoryDto> getInventoryByStoreId(int storeId) throws ResourceNotFoundException{
		
		List<Inventory> inventoryList = inventoryRepository.findByStoreId_storeId(storeId);
		
		if(inventoryList.isEmpty()) {
			
			throw new ResourceNotFoundException("No Inventory found for store with Id: "+storeId);
			
		}		

        return inventoryList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public InventoryDto mapToDto(Inventory inventory) {
        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setInventoryId(inventory.getInventoryId());
        inventoryDto.setStoreId(inventory.getStoreId().getStoreId());
        inventoryDto.setProductId(inventory.getProductId().getProductId());
        inventoryDto.setProductInventory(inventory.getProductInventory());

        // Fetch additional details from other repositories
        inventoryDto.setStoreName(inventory.getStoreId().getStoreName());
        inventoryDto.setProductName(inventory.getProductId().getProductName());
        inventoryDto.setUnitPrice(inventory.getProductId().getUnitPrice());
        inventoryDto.setColour(inventory.getProductId().getColour());
        inventoryDto.setBrand(inventory.getProductId().getBrand());
        inventoryDto.setSize(inventory.getProductId().getSize());
        inventoryDto.setRating(inventory.getProductId().getRating());

        // Fetch order status from Orders repository
        
        List<Orders> ordersList = ordersRepository.findByStoreId_StoreId(inventory.getStoreId().getStoreId());

     
     if (!ordersList.isEmpty()) {
         inventoryDto.setOrderStatus(ordersList.get(0).getOrderStatus());
     } else {
         inventoryDto.setOrderStatus(null);
     }

        return inventoryDto;
    }
		
		
	
	
	}
