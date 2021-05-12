package com.demo.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springmvc.bean.Category;
import com.demo.springmvc.repository.CategoryRepository;
import com.demo.springmvc.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired 
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
}
