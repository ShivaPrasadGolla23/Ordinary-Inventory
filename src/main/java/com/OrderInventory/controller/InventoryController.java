package com.OrderInventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.OrderInventory.dto.InventoryDetailsDto;
import com.OrderInventory.dto.InventoryDto;
import com.OrderInventory.dto.InventoryShipmentCountDto;
import com.OrderInventory.dto.InventoryShipmentCountResponse;
import com.OrderInventory.dto.InventoryShipmentDto;
import com.OrderInventory.entity.Inventory;
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
		
		 @GetMapping("/inventory/{id}")
		    public ResponseEntity<Inventory> getAllProductAndStoreDetails(@PathVariable("id") int inventoryId) throws ResourceNotFoundException {
		        Inventory inventory = inventoryService.getAllProductAndStoreDetails(inventoryId);
				return new ResponseEntity<>(inventory, HttpStatus.OK);
		    }
		  @GetMapping("/shipment")
		    public ResponseEntity<List<InventoryShipmentDto>> getInventoriesAndMatchingShipments() throws ResourceNotFoundException {
		        List<InventoryShipmentDto> inventories = inventoryService.getInventoriesAndMatchingShipments();
		        return new ResponseEntity<>(inventories, HttpStatus.OK);
		    }
		  
		  @GetMapping(("/api/v1/inventory/shipment"))
		  public ResponseEntity<List<InventoryShipmentCountDto>> getShipmentCounts() throws ResourceNotFoundException {
		        List<InventoryShipmentCountDto> shipmentCounts = inventoryService.getShipmentStatusCount();
		        return new ResponseEntity<>(shipmentCounts, HttpStatus.OK);
		    }
		  
		  
		}
	
