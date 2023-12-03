package com.devsuperior.dsdelivery.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsdelivery.entitie.Order;

public interface OrdertRepositorie extends JpaRepository<Order, Long> {
	
	@Query("SELECT DISTINCT obj FROM Order obj JOIN  obj.product"
			+ " WHERE obj.status = 0 ORDER BY obj.moment ASC")
	List<Order> findOrderWithProducts(); 

}
