package com.devsuperior.dsdelivery.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.devsuperior.dsdelivery.entitie.Product;

public interface ProductRepositorie extends JpaRepository<Product, Long> {
	
	
	List<Product> findAllByOrderByNameAsc();

}
