package com.sprinbootdemo_ecommerce.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sprinbootdemo_ecommerce.entity.Product;
import com.sprinbootdemo_ecommerce.global.GlobalData;
import com.sprinbootdemo_ecommerce.repository.ProductRepository;
import com.sprinbootdemo_ecommerce.service.ProductService;
import com.sprinbootdemo_ecommerce.service.UserService;

@Controller
public class CartController {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductService productService;
	@Autowired
	UserService userService;

// add to cart by id

	@GetMapping("/addToCart/{id}")
	public String addToCart(@PathVariable int id) {
		GlobalData.cart.add(productService.getProductById(id).get());
		return "redirect:/shop";
	}

    // get cart

	@GetMapping("/cart")
	public String cartGet(Model model) {

		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		model.addAttribute("cart", GlobalData.cart);
		return "cart";
	}

	// remove from cart

	@GetMapping("/cart/removeItem/{index}")
	public String cartItemRemove(@PathVariable int index) {
		GlobalData.cart.remove(index);
		return "redirect:/cart";
	}

	// checkout

	@GetMapping("/checkout")
	public String checkout(Model model, HttpSession session) {
		
		model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		return "checkout";
	}

	// billing for the customer shopping

	@RequestMapping("/pay")
	public String pay( HttpSession session) {
		session.setAttribute("name", "nishant");

		return "billing";
	}

	// submit
	@RequestMapping("/submit")
	public String sub() {
		return "done";
	}

	@RequestMapping("buyNow")
	public String buy() {
		return "billing";
	}

}
