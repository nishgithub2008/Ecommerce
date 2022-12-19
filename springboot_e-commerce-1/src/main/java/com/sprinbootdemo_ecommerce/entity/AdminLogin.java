package com.sprinbootdemo_ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="adminLogin")
public class AdminLogin {
	@Id
	private String email;
	
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AdminLogin(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	@Override
	public String toString() {
		return "adminLogin [email=" + email + ", password=" + password + "]";
	}
	public AdminLogin() {
		super();
	}
}
