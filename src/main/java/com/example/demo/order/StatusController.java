package com.example.demo.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/status")
public class StatusController {
	
	@Autowired StatusService statusService;
	
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("statuses", statusService.findAll());
		return "status/list";
	}
	
	@GetMapping("/create")
	public String getCreate() {
		return "status/create";
	}
	
	@PostMapping("/create")
	public String postCreate(StatusCreateDTO dto) {
		statusService.save(StatusMapper.INSTANCE.map(dto));
		return "redirect:/status";
	}
	
	@GetMapping("/edit")
	public String GetEdit(Long id, Model model) {
		Status status = statusService.findById(id);
		model.addAttribute("status", status);
		return "status/edit";
	}
	
	@PutMapping("/edit")
	public String postEdit(Long id, StatusEditDTO dto) {
		Status status = StatusMapper.INSTANCE.map(dto);
		status.setId(id);
		statusService.save(status);
		return "redirect:/status";
	}

}
