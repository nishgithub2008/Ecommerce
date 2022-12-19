package com.sprinbootdemo_ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.sprinbootdemo_ecommerce.entity.User;
@Service
public class UserService {	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
// register user
	public boolean insertUser(User user) {
		try {
			String query = "insert into user values(?,?,?)";
			this.jdbcTemplate.update(query, user.getEmail(), user.getPassword(), user.getUsername());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
// login user
	public boolean validateUser(User user) {
		System.err.println("From service"  + user);
		try {
		String sql = "select password from user where email=?";
		String password = jdbcTemplate.queryForObject(sql, String.class, user.getEmail());
		System.err.println(password);
		if (password != null && password.equals(user.getPassword())) {
			System.err.println("Password Matched");
			
			return true;
		}
		}catch(Exception e) {
			return false;
		}
		return false;
	}
  
}
