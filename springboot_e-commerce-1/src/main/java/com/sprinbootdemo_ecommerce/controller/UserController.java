package com.sprinbootdemo_ecommerce.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sprinbootdemo_ecommerce.entity.User;
import com.sprinbootdemo_ecommerce.repository.UserRepository;
import com.sprinbootdemo_ecommerce.service.ProductService;
import com.sprinbootdemo_ecommerce.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserRepository repository;
	@Autowired
	private UserService service;
	@Autowired
	ProductService productService;
	
	public UserController() {
		System.out.println("Home controller Constructor");
	}
	
	@RequestMapping("/")
	public String index()
	{
		System.out.println("index");
		return "index";
	}

	
	@GetMapping("/register")
	public String register(User user)
	{
		
		System.out.println("register");
		return "register";
	}
	
	@PostMapping("/register")
	public String registeringData(  User user )
	{	
		
		System.out.println(user);
		
		
		if(this.service.insertUser(user))
			
			
			return "redirect:login?msg=Registered Successfully";
		else
			return "redirect:register?msg1=Email already exists";	
	}
	
	@RequestMapping("/login")
	public String login()
	{
		System.out.println("login");
		return "login";
	} 
		
	@PostMapping("/login")
	public String loginCreds( User user )
	{
		
		System.out.println(user);
		if(this.service.validateUser(user))
		{
			return "existing";
		}
		else
			return "redirect:login?msg12=Wrong Credentials..!";
	}
	
	@RequestMapping("/existing")
	public String existingUser() {
		return "existing";
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		

		String d = null;
		System.out.println(d.length());
		session.invalidate();
		return "index";
	}


}
