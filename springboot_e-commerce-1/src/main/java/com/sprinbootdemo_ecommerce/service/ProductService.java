package com.sprinbootdemo_ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprinbootdemo_ecommerce.entity.Product;
import com.sprinbootdemo_ecommerce.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	// get all  products

	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}
	
	// add products
	
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	
	//  remove products by id 

	public void removeProductById(int id) {
		productRepository.deleteById(id);
	}
	
	//  get product by id  

	public Optional<Product> getProductById(int id) {
		return productRepository.findById(id);
	}
    
	//  get all  products by categoryId
	
	public List<Product> getAllProductsByCategoryId(int id) {
		return productRepository.findAllByCategory_Id(id);	
	}
	
	// ...........................for search.........................................//
	
	public List<Product> searchProductByName(String productName){
		return productRepository.findByNameContaining(productName);		
	}

	public List<Product> getProductBySearch(String name) {
		return productRepository.findByNameContaining(name);
	}

}
	