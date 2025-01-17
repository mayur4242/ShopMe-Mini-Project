package com.ecom.service;

import java.util.List;

import com.ecom.models.Category;

public interface ICategoryService {
	
	public List<Category> getAllCategory();
	
	public Boolean existsCategory(String name);
	
	public Category saveCategory(Category category);
	
	public Category deleteCategory( Integer id);
	
	
	
	

}
