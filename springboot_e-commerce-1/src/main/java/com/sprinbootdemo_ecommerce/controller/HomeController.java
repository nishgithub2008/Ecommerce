package com.sprinbootdemo_ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sprinbootdemo_ecommerce.global.GlobalData;
import com.sprinbootdemo_ecommerce.service.CategoryService;
import com.sprinbootdemo_ecommerce.service.ProductService;
import com.sprinbootdemo_ecommerce.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;  
	
	@Autowired
	UserService service;
	
// home page

	@GetMapping({ "/", "/home" })
	public String home(Model model) {
		
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "index";
	}
	
	@GetMapping("/shop")
	public String shop(Model model) {
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("products", productService.getAllProduct());
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "shop";
	}
	
	@GetMapping("/shop/category/{id}")
	public String shopByCategory(Model model, @PathVariable int id) {
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("products", productService.getAllProductsByCategoryId(id));
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "shop";
	}
	
	
	
	@GetMapping("/shop/viewproduct/{id}")
	public String viewProduct(Model model, @PathVariable int id) {
		
		model.addAttribute("product", productService.getProductById(id).get());
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "viewProduct";
	}
	
	

}
