package com.example.demo.cart;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.order.Order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@OneToMany
	List<CartItem> items = new ArrayList<CartItem>();
	@OneToOne(mappedBy = "cart")
	Order order;

}
