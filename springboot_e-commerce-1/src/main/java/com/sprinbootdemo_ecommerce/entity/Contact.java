package com.sprinbootdemo_ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="query")
public class Contact {
	
	private String fullName;
	@Id
	private String email;
	private String message;
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Contact(String fullName, String email, String message) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.message = message;
	}
	public Contact() {
		super();
	}
	@Override
	public String toString() {
		return "Contact [fullName=" + fullName + ", email=" + email + ", message=" + message + "]";
	}
	
	
}
