package com.ecom.controller;

import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecom.service.ICategoryService;
import com.ecom.serviceImpl.CategoryServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	 private ICategoryService cateservice;
	
	@GetMapping("/")
	public String index() {
		
		return "admin/index";
	}
	
	@GetMapping("/addproduct")
	public String showAddProduct() {
		
		return "admin/add-product";
	}
	
	@GetMapping("/category")
	public String showCategory() {
		
		return "admin/category";
	}
	
	@PostMapping("/savecategory")
	public String savecategory(@ModelAttribute Category category, HttpSession session) {
		
		
		return "redirect:/category";
	}

}
