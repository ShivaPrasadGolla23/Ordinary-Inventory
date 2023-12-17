package com.OrderInventory.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;


@Entity
@Data
public class OrderItems {
	
	
	@EmbeddedId
	private OrderItemsId id;
	
	private int lineItemId;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private Products productId;
	
	private double unitPrice;
	private int quantity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shipments_id")
	private Shipments shipmentId;

}
