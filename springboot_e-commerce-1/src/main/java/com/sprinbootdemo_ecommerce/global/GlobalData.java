package com.sprinbootdemo_ecommerce.global;

import java.util.ArrayList;
import java.util.List;

import com.sprinbootdemo_ecommerce.entity.Product;

public class GlobalData {
	
	public static List<Product> cart;
	
	static {
		cart=new ArrayList<Product>();
	}

}
