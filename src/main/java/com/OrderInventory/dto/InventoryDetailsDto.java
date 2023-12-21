package com.OrderInventory.dto;

public class InventoryDetailsDto {

    private int productId;
    private String productName;
    private String storeName;
    private String shipmentStatus;
    // Add other fields as needed

    // Constructors, getters, and setters

    public InventoryDetailsDto() {
        // Default constructor
    }

    public InventoryDetailsDto(int productId, String productName, String storeName, String shipmentStatus) {
        this.productId = productId;
        this.productName = productName;
        this.storeName = storeName;
        this.shipmentStatus = shipmentStatus;
    }

    // Add getters and setters for other fields as needed

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getShipmentStatus() {
        return shipmentStatus;
    }

    public void setShipmentStatus(String shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }
}

