package com.sprinbootdemo_ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprinbootdemo_ecommerce.entity.Category;
import com.sprinbootdemo_ecommerce.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

// save categories
	public void category(Category category) {
		categoryRepository.save(category);
		System.err.println(category);	
	}

// get all categories
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

// remove category by id
	public void removeCategoryById(int id) {
		categoryRepository.deleteById(id);
	}

// fetchCategoryById categories

	public Optional<Category> fetchCategoryById(int id) {
		return categoryRepository.findById(id);
	}
}
