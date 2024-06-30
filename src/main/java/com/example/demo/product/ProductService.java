package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired private ProductRepository productRepository;
	
	public Product create(Product product) {
		return productRepository.save(product);
	}
	
	public Product getProduct(Long id) {
		return productRepository.findById(id).orElseThrow(ResourceNotFoundException::new);

	}
	
	public Iterable<Product> findall() {
		return productRepository.findAll();
	}

	public void delete(Long id) {
		productRepository.deleteById(id);
		
	}

	public Product findById(Long id) {
		return productRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
	}

	public Product save(Product map) {
		return productRepository.save(map);
	}
	
}
