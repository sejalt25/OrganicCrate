package com.demo.springmvc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.springmvc.bean.Category;
import com.demo.springmvc.bean.Disease;
import com.demo.springmvc.bean.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product ,Long> {

	public List<Product> findByCategory(Category cat);
	public List<Product> findByDisease(Disease dis);
	public List<Product> findByCategoryAndDisease(Category category, Disease disease);
	
	Optional<Product> findByPid(long pid);
}
