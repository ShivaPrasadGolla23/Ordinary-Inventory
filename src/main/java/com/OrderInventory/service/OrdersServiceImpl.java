package com.OrderInventory.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OrderInventory.dto.OrderStatusCountDto;
import com.OrderInventory.dto.OrdersDto;
import com.OrderInventory.entity.Orders;
import com.OrderInventory.exception.ResourceNotFoundException;
import com.OrderInventory.repository.OrdersRepository;

import jakarta.validation.Valid;



@Service
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;

    @Autowired
    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public List<Orders> fetchAllOrders() {
        List<Orders> ordersList = ordersRepository.findAll();
        
        return ordersList;
    }

	/*@Override
	public List<Orders> getOrdersByStatus(String orderstatus) {
		// TODO Auto-generated method stub
		return ordersRepository.findByOrderStatus(orderstatus);
	}*/
    
    @Override
	public List<OrderStatusCountDto> getOrderStatusCount() {
		
		List<Object[]> result= ordersRepository.getOrderStatusCount();
		
		List<OrderStatusCountDto> orderStatusCount = result.stream()
				.map(objects -> new OrderStatusCountDto((String) objects[0], (Long) objects[1]))
                .collect(Collectors.toList());
		
		return orderStatusCount;
	}
	@Override
    public Orders updateOrder(int orderId, Orders updatedOrder) {
        if (ordersRepository.existsById(orderId)) {
            updatedOrder.setOrderId(orderId);
            return ordersRepository.save(updatedOrder);
        }
        return null; // Handle not found scenario
    }
	@Override
	public void deleteOrderById(int ordersId) {
		 Optional<Orders> ordersdel = ordersRepository.findById(ordersId);
	}

	@Override
    public void createOrder(Orders newOrder) {
        ordersRepository.save(newOrder);
    }

	@Override
	public String deleteOrdersById(@Valid int ordersId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<OrdersDto> getOrdersByStoreName(String store) throws ResourceNotFoundException {
		
		List<Orders> orders= ordersRepository.findByStoreId_StoreName(store);
		
		if (orders.isEmpty()) {
			
            throw new ResourceNotFoundException("No Store found with name: " + store);
        } 
		else 
        {
            // Mapping each order to OrdersDto
        	
            List<OrdersDto> ordersDtoList = orders.stream()
                    .map(order -> {
                        OrdersDto ordersDto = new OrdersDto();
                        ordersDto.setOrderId(order.getOrderId());
                        ordersDto.setOrderStatus(order.getOrderStatus());
                        ordersDto.setStoreName(order.getStoreId().getStoreName());
                        ordersDto.setWebAddress(order.getStoreId().getWebAddress());
                        return ordersDto;
                    })
                    .collect(Collectors.toList());

            return ordersDtoList;
        }	
	
}
}
