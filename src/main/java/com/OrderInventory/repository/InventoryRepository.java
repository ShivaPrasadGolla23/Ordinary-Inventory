package com.OrderInventory.repository;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OrderInventory.entity.Inventory;

@Repository

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

	



	

		
}