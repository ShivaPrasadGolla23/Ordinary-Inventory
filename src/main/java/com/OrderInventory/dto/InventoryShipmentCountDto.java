package com.OrderInventory.dto;

import lombok.Data;

@Data
public class InventoryShipmentCountDto {

    private String shipmentStatus;
    private long productCount;

    public InventoryShipmentCountDto(Object object, long productCount) {
        this.shipmentStatus = String.valueOf(object);
        this.productCount = productCount;
    }
}
