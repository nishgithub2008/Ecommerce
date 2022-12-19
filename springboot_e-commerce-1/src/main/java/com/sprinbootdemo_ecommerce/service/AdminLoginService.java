package com.sprinbootdemo_ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprinbootdemo_ecommerce.entity.AdminLogin;
import com.sprinbootdemo_ecommerce.repository.AdminLoginRepo;

@Service
public class AdminLoginService {

	@Autowired
	private AdminLoginRepo adminLoginRepo;

	// ADmin login
	public boolean loginAdmin(AdminLogin a)

	{
		if (this.adminLoginRepo.existsById(a.getEmail())) {
			
			String password = this.adminLoginRepo.findById(a.getEmail()).get().getPassword();
			
			if (a.getPassword().equals(password)) {
				return true;
			}
		}
		return false;

	}

}
