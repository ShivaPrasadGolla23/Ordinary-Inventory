package com.OrderInventory.dto;

import lombok.Data;

@Data
public class OrdersDto {
	
	private int orderId;
	private String orderStatus;
	private String storeName;
	private String webAddress;

}