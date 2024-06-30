package com.example.demo.product;

import lombok.Data;

@Data
public class ProductEditDTO {
	
	String label;
	String description;
	Integer price;
	Long category;
	State state;
	Float sale;

}
