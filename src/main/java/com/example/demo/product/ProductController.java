package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.category.CategoryServise;


@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired private ProductService productService;
	@Autowired private CategoryServise categoryService;
	
	@GetMapping("/create")
	public String getCreateProduct(Model model) {
		model.addAttribute("categories", categoryService.findall());
		return "product/create";
	}
	
	@PostMapping("/create")
	public String postCreateProduct(ProductCreateDTO dto) {
		Product product = productService.create(ProductMapper.INSTANCE.fromDTO(dto));
		return "redirect:/product?id=" + product.getId().toString();
	}
	
	@GetMapping
	public String getProduct(Long id, Model model) {
		Product product = productService.getProduct(id);
		model.addAttribute("product", product);
		return "product/info";
	}
	
	@GetMapping("/delete")
	public String delete(Long id) {
		productService.delete(id);
		return "redirect:/product/list";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("products", productService.findall());
		return "product/list";
	}
	
	@GetMapping("/edit")
	public String GetEdit(Long id, Model model) {
		Product product = productService.findById(id);
		model.addAttribute("product", product);
		model.addAttribute("categories", categoryService.findall());
		return "product/edit";
	}
	
	@PutMapping("/edit")
	public String postEdit(Long id, ProductEditDTO dto) {
		Product product = ProductMapper.INSTANCE.map(dto);
		product.setId(id);
		productService.save(product);
		return "redirect:/product/list";
	}

}
