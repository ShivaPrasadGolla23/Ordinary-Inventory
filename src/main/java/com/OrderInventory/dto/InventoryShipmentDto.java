package com.OrderInventory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryShipmentDto {

    private int inventoryId;
    private int storeId;
    private int productId;
    private int productInventory;
    private String shipmentStatus;

    // Other fields, getters, and setters
}