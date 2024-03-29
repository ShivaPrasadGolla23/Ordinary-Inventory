package com.example.OrderInventory;



import com.OrderInventory.controller.InventoryController;
import com.OrderInventory.dto.InventoryDto;
import com.OrderInventory.entity.Inventory;
import com.OrderInventory.exception.ResourceNotFoundException;
import com.OrderInventory.service.InventoryService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InventoryControllerTest {

    @Mock
    private InventoryService inventoryService;

    @InjectMocks
    private InventoryController inventoryController;

    public InventoryControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetInventoryByStoreId() throws ResourceNotFoundException {
        // Arrange
        int storeId = 1;
        List<InventoryDto> mockInventoryList = Arrays.asList(new InventoryDto(), new InventoryDto());
        when(inventoryService.getInventoryByStoreId(storeId)).thenReturn(mockInventoryList);

        // Act
        ResponseEntity<List<InventoryDto>> responseEntity = inventoryController.getInventoryByStoreId(storeId);

        // Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockInventoryList, responseEntity.getBody());

        // Add more assertions based on your business logic
    }

    @Test
    void testGetInventoryByStoreIdResourceNotFoundException() throws ResourceNotFoundException {
        // Arrange
        int storeId = 1;
        when(inventoryService.getInventoryByStoreId(storeId)).thenThrow(new ResourceNotFoundException("No Inventory found"));

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> inventoryController.getInventoryByStoreId(storeId));
    }
    
    @Test
    void testGetAllProductAndStoreDetails() throws ResourceNotFoundException {
        // Arrange
        int inventoryId = 1;
        Inventory mockInventory = new Inventory(); // Create a mock Inventory object

        // Mock the behavior of the inventoryService
        when(inventoryService.getAllProductAndStoreDetails(inventoryId)).thenReturn(mockInventory);

        // Act
        ResponseEntity<Inventory> response = inventoryController.getAllProductAndStoreDetails(inventoryId);

        // Assert
        // Verify that the service method was called with the correct parameter
        verify(inventoryService, times(1)).getAllProductAndStoreDetails(inventoryId);

        // Verify that the response entity has the correct status code and inventory object
        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody() == mockInventory;
    }


}





