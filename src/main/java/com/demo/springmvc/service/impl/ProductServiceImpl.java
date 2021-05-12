package com.demo.springmvc.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springmvc.repository.CategoryRepository;
import com.demo.springmvc.repository.DiseaseRepository;
import com.demo.springmvc.repository.ProductRepository;
import com.demo.springmvc.service.ProductService;
import com.demo.springmvc.bean.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;


	@Autowired
	DiseaseRepository diseaseRepository;


	@Override
	public List<Product> findAll() {

		return productRepository.findAll();
	}

	@Override
	public void save(Product p) {
		productRepository.save(p);
	}

	@Override
	public void update(Product p) {
		productRepository.save(p);
	}

	@Override
	public void delete(Long id) {
		productRepository.deleteById(id);
	}

	@Override
	public Object findById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public List<Product> findByCid(Long cid) {

		return productRepository.findByCategory(categoryRepository.findById(cid).get());
	}

	@Override
	public List<Product> findByDiseaseId(Long did) {

		return productRepository.findByDisease(diseaseRepository.findById(did).get());
	}

	@Override
	public List<Product> findByCidAndDid(Long cid, Long did) {
		
		return productRepository.findByCategoryAndDisease(categoryRepository.findById(cid).get(),diseaseRepository.findById(did).get());
	}
}
