package com.example.demo.order;

import lombok.Data;

@Data
public class OrderCreateDTO {
	
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

}
