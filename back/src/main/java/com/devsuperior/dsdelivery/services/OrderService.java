package com.devsuperior.dsdelivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdelivery.dto.OrderDto;
import com.devsuperior.dsdelivery.entitie.Order;
import com.devsuperior.dsdelivery.repositories.OrdertRepositorie;


@Service
public class OrderService {
	
	@Autowired
	private OrdertRepositorie repo;
	
	@Transactional(readOnly = true)
	public List<OrderDto> findAll(){
		List<Order> list = repo.findOrderWithProducts();
		return list.stream().map(x -> new OrderDto(x)).collect(Collectors.toList());  
	}
}
