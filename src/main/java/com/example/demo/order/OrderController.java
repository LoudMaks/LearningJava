package com.example.demo.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired OrderService orderService;
	
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("orders", orderService.findAll());
		return "order/list";
	}
	
	@GetMapping("/create")
	public String getCreate() {
		return "order/create";
	}
	
	@PostMapping("/create")
	public String postCreate(OrderCreateDTO dto) {
		orderService.save(OrderMapper.INSTANCE.map(dto));
		return "redirect:/order";
	}
	
	@GetMapping("/edit")
	public String GetEdit(Long id, Model model) {
		Order order = orderService.findById(id);
		model.addAttribute("order", order);
		return "order/edit";
	}
	
	@PutMapping("/edit")
	public String postEdit(Long id, OrderEditDTO dto) {
		Order order = OrderMapper.INSTANCE.map(dto);
		order.setId(id);
		orderService.save(order);
		return "redirect:/order";
	}
	

}
