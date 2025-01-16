package com.ecom.serviceImpl;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ecom.repository.ICategoryRepository;
import com.ecom.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
	private ICategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAllCategory() {
		
		List<Category> allcate = categoryRepository.findAll();
		return allcate;
	}

	@Override
	public Category saveCategory(Category category) {
		Category savecategory =  categoryRepository.save(category);
		return savecategory;
	}
	
	

	

}
