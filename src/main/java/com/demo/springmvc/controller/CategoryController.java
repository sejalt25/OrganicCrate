package com.demo.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.demo.springmvc.bean.Category;
import com.demo.springmvc.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired 
	private CategoryService categoryService;
    
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_VENDOR','ROLE_PATIENT')")
	@GetMapping(value = {"/admin/category","/user/category","/vendor/category","/patient/category"})
	public String forCategory(Model model){
		List<Category> categoryList = categoryService.findAll();
		model.addAttribute("categoryList", categoryList);
		return "category";
	}

}
