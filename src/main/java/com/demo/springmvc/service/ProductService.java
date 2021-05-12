package com.demo.springmvc.service;

import java.util.List;

import com.demo.springmvc.bean.Product;

public interface ProductService {

	void save(Product p);

	void update(Product p);

	void delete(Long id);

	Object findAll();

	Object findById(Long pid);
	
	Object findByCid(Long cid);

	List<Product> findByDiseaseId(Long diseaseId);

	List<Product> findByCidAndDid(Long cid, Long diseaseId);

	
}
