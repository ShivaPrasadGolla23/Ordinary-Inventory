package com.OrderInventory.entity;

import com.OrderInventory.dto.InventoryDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inventoryId;
	
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Stores storeId;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Products productId;
	
	
	 @ManyToOne
	    @JoinColumn(name = "shipment_id")
	    private Shipments shipment;
	
	private int productInventory;

	


	
}
