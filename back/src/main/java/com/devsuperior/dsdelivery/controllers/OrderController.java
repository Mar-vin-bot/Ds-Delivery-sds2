package com.devsuperior.dsdelivery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsdelivery.dto.OrderDto;
import com.devsuperior.dsdelivery.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<OrderDto>> findAll(){
		List<OrderDto> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<OrderDto> insert(@RequestBody OrderDto dto){
		dto = service.insert(dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@PutMapping("/{id}/delivered")
	public ResponseEntity<OrderDto> setDelivered(@PathVariable Long id){
		OrderDto dto = service.setDelivered(id);
		return ResponseEntity.ok().body(dto);
	}
	
	
}
