package com.OrderInventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OrderInventory.entity.Orders;
import com.OrderInventory.repository.OrdersRepository;



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

	@Override
	public List<Orders> getOrdersByStatus(String orderstatus) {
		// TODO Auto-generated method stub
		return ordersRepository.findByOrderStatus(orderstatus);
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
	
	 
	}
