package com.example.demo.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexControler {
	
	@GetMapping("/hello")
	public String hello() {
		return "index";
	}

}
