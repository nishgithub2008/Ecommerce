package com.sprinbootdemo_ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sprinbootdemo_ecommerce.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findAllByCategory_Id(int id);
	
	public  List<Product> findByNameContaining(String name);
	
	
	
	
	
	
	
	
}
