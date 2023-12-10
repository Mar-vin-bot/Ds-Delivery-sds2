package com.devsuperior.dsdelivery.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdelivery.dto.OrderDto;
import com.devsuperior.dsdelivery.dto.ProductDTO;
import com.devsuperior.dsdelivery.entitie.Order;
import com.devsuperior.dsdelivery.entitie.OrderStatus;
import com.devsuperior.dsdelivery.entitie.Product;
import com.devsuperior.dsdelivery.repositories.OrdertRepositorie;
import com.devsuperior.dsdelivery.repositories.ProductRepositorie;


@Service
public class OrderService {
	
	@Autowired
	private OrdertRepositorie repo;
	
	@Autowired
	private ProductRepositorie productRepo;
	
	@Transactional(readOnly = true)
	public List<OrderDto> findAll(){
		List<Order> list = repo.findOrderWithProducts();
		return list.stream().map(x -> new OrderDto(x)).collect(Collectors.toList());  
	}
	
	@Transactional
	public OrderDto insert(OrderDto dto) {
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), 
				Instant.now(), OrderStatus.PENDING);
		
		//associar os products a Ordem
		 for(ProductDTO prod : dto.getProductDTO()) {
			 Product product = productRepo.getReferenceById(prod.getId());
					order.getProduct().add(product);
		 }
		 order = repo.save(order);
		 return new OrderDto(order); 
	}
}
