package com.OrderInventory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InventoryShipmentCountResponse {
    private String shipmentStatus;
    private long productCount;
}