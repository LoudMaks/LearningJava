package com.example.demo.order;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.cart.Cart;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "order_")
@Getter
@Setter
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	String firstName;
	String secondName;
	String surname;
	String fullName;
	
	String tel;
	String secondTel;
	String email;
	
	String adress1;
	String adress2;
	String city;
	String country;
	
	@OneToOne
	Cart cart;
	
	@OneToMany
	List<OrderStatus> orderStatus = new ArrayList<OrderStatus>();

}
