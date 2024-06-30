package com.example.demo.category;

public class CategoryCreateDTO {
	
	String label;
	String description;
	Long parentCategory;
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(Long parentCategory) {
		this.parentCategory = parentCategory;
	}

}
