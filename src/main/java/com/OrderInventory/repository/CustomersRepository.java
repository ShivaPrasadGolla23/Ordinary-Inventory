package com.OrderInventory.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.OrderInventory.entity.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer>{
	
	List<Customers> findByEmailAddress(String email);
	List<Customers> findByFullName(String name);
	
	@Query(nativeQuery = true,
	           value = "SELECT shipment_status, COUNT(customer_id) as customersCount FROM shipments GROUP BY shipment_status")
	
	List<Object[]> getShipmentStatusWiseCustomerCount();

}