package com.ecom.service;

import java.util.List;
import java.util.Locale.Category;

public interface ICategoryService {
	
	public List<Category> getAllCategory();
	
	public Category saveCategory(Category category);
	
	

}
