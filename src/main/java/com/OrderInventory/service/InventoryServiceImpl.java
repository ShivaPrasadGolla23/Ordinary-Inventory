package com.OrderInventory.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.OrderInventory.dto.InventoryDto;
import com.OrderInventory.dto.InventoryShipmentDto;
import com.OrderInventory.entity.Inventory;
import com.OrderInventory.entity.Orders;
import com.OrderInventory.entity.Shipments;
import com.OrderInventory.exception.ResourceNotFoundException;
import com.OrderInventory.repository.InventoryRepository;
import com.OrderInventory.repository.OrdersRepository;
import com.OrderInventory.repository.ShipmentsRepository;

@Service
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	InventoryRepository inventoryRepository;
	@Autowired
	OrdersRepository ordersRepository;
	
	@Autowired
    private ShipmentsRepository shipmentsRepository;

	@Override
	public List<InventoryDto> getInventoryByStoreId(int storeId) throws ResourceNotFoundException{
		
		List<Inventory> inventoryList = inventoryRepository.findByStoreId_storeId(storeId);
		
		if(inventoryList.isEmpty()) {
			
			throw new ResourceNotFoundException("No Inventory found for store with Id: "+storeId);
			
		}		

        return inventoryList.stream()
                .map(this::mapToDto1)
                .collect(Collectors.toList());
    }

    public InventoryDto mapToDto1(Inventory inventory) {
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

    @Override
    public Inventory getAllProductAndStoreDetails(int inventoryId) {
        return inventoryRepository.findByInventoryId(inventoryId);
    }
    
    @Override
    public List<InventoryShipmentDto> getInventoriesAndMatchingShipments() throws ResourceNotFoundException {
        List<Inventory> inventories = inventoryRepository.findAll();

        if (inventories.isEmpty()) {
            throw new ResourceNotFoundException("No inventories found.");
        }

        return inventories.stream()
                .map(this::mapToShipmentDto)
                .collect(Collectors.toList());
    }

 // Assuming productId is an integer in your Inventory entity
    private InventoryShipmentDto mapToShipmentDto(Inventory inventory) {
        Shipments shipment = inventory.getShipment();
        return new InventoryShipmentDto(
                inventory.getInventoryId(),
                inventory.getStoreId().getStoreId(),
                inventory.getProductId() != null ? inventory.getProductId().getProductId() : null,
                inventory.getProductInventory(),
                getShipmentStatus(inventory)
        );
    }

    private String getShipmentStatus(Inventory inventory) {
        Shipments shipment = inventory.getShipment();
        return shipment != null ? shipment.getShipmentStatus() : null;
    }
    
    
    
}

    

    
   