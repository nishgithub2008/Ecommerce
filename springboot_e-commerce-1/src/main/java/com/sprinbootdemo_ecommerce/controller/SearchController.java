package com.sprinbootdemo_ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sprinbootdemo_ecommerce.entity.Product;
import com.sprinbootdemo_ecommerce.service.ProductService;

@Controller
public class SearchController {
	
	@Autowired
	ProductService productService;
	
	
	@PostMapping("/search")
	public @ResponseBody List<Product> getProductByName(@RequestBody String productName) throws JSONException {
		JSONObject jsonObj= new JSONObject(productName);
		String name= jsonObj.getString("productName");
		
		if(name.trim().isEmpty()) {
			name="";
		}
		return this.productService.searchProductByName(name);
	}

}
