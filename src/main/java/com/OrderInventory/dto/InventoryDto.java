package com.OrderInventory.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class InventoryDto {
	
	 private int inventoryId;
	    private int storeId;
	    private int productId;
	    private int productInventory;
	    private String storeName;
	    private String productName;
	    private double unitPrice;
	    private String colour;
	    private String brand;
	    private String size;
	    private int rating;
	    private String orderStatus;

}