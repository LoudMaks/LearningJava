package com.example.demo.category;

import lombok.Data;

@Data
public class CategoryEditDTO {
	
	String label;
	String description;
	Long parentCategory;

}
