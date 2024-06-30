package com.example.demo.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired CategoryServise categoryService;
	
	@GetMapping("/create")
	public String createCategory(Model model) {
		model.addAttribute("categories", categoryService.findall());
		return "category/create";
	}
	
	@PostMapping("/create")
	public String postCreateCategory(CategoryCreateDTO dto) {
		Category category = categoryService.create(CategoryMapper.INSTANCE.fromDTO(dto));
		return "redirect:/category?id=" + category.getId().toString();
	}
	
	@GetMapping
	public String getCategory(Long id, Model model) {
		Category category = categoryService.getCategory(id);
		model.addAttribute("category", category);
		return "category/info";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("categories", categoryService.findall());
		return "category/list";
	}
	
	@GetMapping("/edit")
	public String GetEdit(Long id, Model model) {
		Category category = categoryService.findById(id);
		List<Category> categories = (List<Category>) categoryService.findall();
		model.addAttribute("category", category);
		model.addAttribute("categories", categories);
		return "category/edit";
	}
	
	@PutMapping("/edit")
	public String postEdit(Long id, CategoryEditDTO dto) {
		Category category = CategoryMapper.INSTANCE.map(dto);
		category.setId(id);
		categoryService.save(category);
		return "redirect:/category/list";
	}
}
