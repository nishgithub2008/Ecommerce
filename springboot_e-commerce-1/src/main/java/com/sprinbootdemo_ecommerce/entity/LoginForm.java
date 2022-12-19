package com.sprinbootdemo_ecommerce.entity;
import org.springframework.stereotype.Component;

@Component
public class LoginForm {
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
		public LoginForm( String email, String password) {
			super();
			this.email = email;
			this.password = password;
		}
		@Override
		public String toString() {
			return "LoginForm [email=" + email + ", password=" + password + "]";
		}
		public LoginForm() {
			super();
		}
	    
	    

}
