package com.example.demo.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.order.OrderRepository;

@Service
public class CategoryServise {
	
	@Autowired CategoryRepository categoryRepository;

	public Category create(Category category) {
		return categoryRepository.save(category);
		
	}

	public Category getCategory(Long id) {
		return categoryRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
	}

	public Iterable<Category> findall() {
		return categoryRepository.findAll();
	}

	public Category findById(Long id) {
		return categoryRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
	}

	public Category save(Category map) {
		return categoryRepository.save(map);
		
	}

}
