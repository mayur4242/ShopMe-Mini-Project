package com.ecom.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.ecom.models.Category;
import com.ecom.repository.ICategoryRepository;
import com.ecom.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ICategoryRepository categoryRepository;

	@Override
	public List<Category> getAllCategory() {

		List<Category> getCategory = categoryRepository.findAll();
		return getCategory;

	}

	@Override
	public Boolean existsCategory(String name) {
		return categoryRepository.existsByName(name);
	}

	@Override
	public Category saveCategory(Category category) {
		Category saveCategory = categoryRepository.save(category);
		return saveCategory;
	}

	@Override
	public Category deleteCategory(Integer id) {
	Optional<Category> deleteCategory = 	categoryRepository.findById(id);
	
	if (categoryRepository.existsById(id)) {
        categoryRepository.deleteById(id);
    } else {
        throw new RuntimeException("Category not found with ID " + id);
    }
	
	
		return null;
	}

}
