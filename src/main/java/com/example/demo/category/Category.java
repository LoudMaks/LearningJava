package com.example.demo.category;

import java.util.List;

import com.example.demo.product.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String label;
	String description;
	@OneToMany(mappedBy = "category")
	List<Product> products;
	@ManyToOne//(cascade = CascadeType.ALL)
	Category parentCategory;
	@OneToMany(mappedBy = "parentCategory")
	List<Category> childCategory;
	
	public Long getId() {
		return id;
	}
	public Category(Long id) {
		super();
		this.id = id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Category getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}
	public List<Category> getChildCategory() {
		return childCategory;
	}
	public void setChildCategory(List<Category> childCategory) {
		this.childCategory = childCategory;
	}
	public Category() {
		super();
	}

}
