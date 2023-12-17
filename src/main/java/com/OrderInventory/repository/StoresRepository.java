package com.OrderInventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.OrderInventory.entity.Stores;

@Repository

public interface StoresRepository extends JpaRepository<Stores, Integer> {
	
}
