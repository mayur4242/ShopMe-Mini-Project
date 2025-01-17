package com.ecom.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.models.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
	//Custom method for check category available or not
	public Boolean existsByName(String name);

	
}
