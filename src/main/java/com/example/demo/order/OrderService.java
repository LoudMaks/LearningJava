package com.example.demo.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	
	@Autowired OrderRepository orderRepository;

	public Iterable<Order> findAll() {
		return orderRepository.findAll();
	}

	public Order save(Order map) {
		return orderRepository.save(map);
	}

	public Order findById(Long id) {
		return orderRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
				
	}

}
