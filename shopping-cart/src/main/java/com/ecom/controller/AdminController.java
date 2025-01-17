package com.ecom.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecom.models.Category;
import com.ecom.service.ICategoryService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ICategoryService categoryService;

	@GetMapping("/")
	public String index() {

		return "admin/index";
	}

	@GetMapping("/addproduct")
	public String showAddProduct() {

		return "admin/add-product";
	}

	@GetMapping("/category")
	public String showCategory(Model model) {

		model.addAttribute("category", categoryService.getAllCategory());

		return "admin/category";
	}

	@PostMapping("/savecategory")
	public String savecategory(@ModelAttribute Category category, @RequestParam("image") MultipartFile image,
			RedirectAttributes redirectAttributes) {

		String imageName;

		// Check if an image is provided
		if (image != null && !image.isEmpty()) {
			// If an image is provided, get its original filename
			imageName = image.getOriginalFilename();

			// Save the image to a directory (optional)
			try {
				String uploadDir = "D:\\Workspace\\S.ImageEcomProj"; // Define the directory where you want to save
																		// images
				File uploadFile = new File(uploadDir + "/" + imageName);

				// Save the image to the specified path
				image.transferTo(uploadFile);
			} catch (IOException e) {
				e.printStackTrace();
				// Handle error (set a default image or show an error message)
				imageName = "Default image.png"; // Use default image in case of an error
				redirectAttributes.addFlashAttribute("ErrorMsg", "Image upload failed. Using default image.");
			}
		} else {
			// If no image is provided, use the default image
			imageName = "Default image.png";
		}

		// Set the image name to the category
		category.setImageName(imageName);

		// Check if the category already exists
		Boolean existCategory = categoryService.existsCategory(category.getName());
		if (existCategory) {
			redirectAttributes.addFlashAttribute("ErrorMsg", "Category Already Exists");
		} else {
			// Save the category
			Category savedCategory = categoryService.saveCategory(category);

			if (savedCategory == null) {
				redirectAttributes.addFlashAttribute("ErrorMsg", "Not Saved! Internal Server Error");
			} else {
				redirectAttributes.addFlashAttribute("SuccessMsg", "Saved Successfully");
			}
		}

		// Redirect to the category page
		return "redirect:/admin/category";

	}

	@DeleteMapping("/deletecategory/{id}")
	public String deleteCategory(Integer id) {

		Category delete = categoryService.deleteCategory(id);

		return "redirect:/admin/category";

	}

}
