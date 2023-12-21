package com.example.OrderInventory;

import com.OrderInventory.controller.OrdersController;
import com.OrderInventory.dto.OrderStatusCountDto;
import com.OrderInventory.dto.OrdersDto;
import com.OrderInventory.entity.Orders;
import com.OrderInventory.exception.ResourceNotFoundException;
import com.OrderInventory.service.OrdersService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrdersControllerTest {

    @Mock
    private OrdersService ordersService;

    @InjectMocks
    private OrdersController ordersController;

    @Test
    public void testDisplayAllInventory() {
        // Mock data
        List<Orders> mockOrdersList = Arrays.asList(new Orders(), new Orders());
        when(ordersService.fetchAllOrders()).thenReturn(mockOrdersList);

        // Test
        ResponseEntity<List<Orders>> responseEntity = ordersController.displayAllInventory();

        // Verify
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockOrdersList, responseEntity.getBody());
        verify(ordersService, times(1)).fetchAllOrders();
    }

    // Add more test cases for other methods similarly...

    @Test
    public void testGetOrderStatusCount() {
        // Mock data
        List<OrderStatusCountDto> mockOrderStatusCount = Arrays.asList(new OrderStatusCountDto(), new OrderStatusCountDto());
        when(ordersService.getOrderStatusCount()).thenReturn(mockOrderStatusCount);

        // Test
        List<OrderStatusCountDto> result = ordersController.getOrderStatusCount();

        // Verify
        assertEquals(mockOrderStatusCount, result);
        verify(ordersService, times(1)).getOrderStatusCount();
    }

    @Test
    public void testUpdateOrder() {
        // Mock data
        int orderId = 1;
        Orders updatedOrder = new Orders();
        when(ordersService.updateOrder(orderId, updatedOrder)).thenReturn(updatedOrder);

        // Test
        Orders result = ordersController.updateOrder(orderId, updatedOrder);

        // Verify
        assertEquals(updatedOrder, result);
        verify(ordersService, times(1)).updateOrder(orderId, updatedOrder);
    }

       @Test
        public void testDeleteOrdersById() {
        // Mock data
        int orderId = 1;

        // Test
        ResponseEntity<String> responseEntity = ordersController.deleteOrdersById(orderId);

       // Verify
         assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Customer deleted with id : " + orderId, responseEntity.getBody());
    }

    // Add more test cases for other methods similarly...

    @Test
    public void testGetOrdersByStoreName() throws ResourceNotFoundException {
        // Mock data
        String storeName = "Store1";
        List<OrdersDto> mockOrdersDtoList = Arrays.asList(new OrdersDto(), new OrdersDto());
        when(ordersService.getOrdersByStoreName(storeName)).thenReturn(mockOrdersDtoList);

        // Test
        List<OrdersDto> result = ordersController.getOrdersByStoreName(storeName);

        // Verify
        assertEquals(mockOrdersDtoList, result);
        verify(ordersService, times(1)).getOrdersByStoreName(storeName);
    }
}