package com.OrderInventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.OrderInventory.entity.Shipments;

@Repository

public interface ShipmentsRepository extends JpaRepository<Shipments, Integer> {
	
}
