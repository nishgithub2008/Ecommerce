package com.sprinbootdemo_ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.sprinbootdemo_ecommerce.entity.AdminLogin;
import com.sprinbootdemo_ecommerce.service.AdminLoginService;

@Controller
public class AdminLoginController {
	
	@Autowired
	private AdminLoginService adminLoginService;

	@GetMapping("/admin")
	public String admin() {
		return "adminLogin";
	}

	@GetMapping("/enter")
	public String enter() {
		return "enter";
	}
	
	//adminHome Page
	@PostMapping("/adminHome")
	public String login(AdminLogin adminLogin) {	
		System.out.println(adminLogin);
		if (this.adminLoginService.loginAdmin(adminLogin)) {
			return "adminHome";
		
		}
		return "redirect:admin?msg8=Wrong Credentials";


	}
	
	
	
	 
}
