package com.demo.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.springmvc.bean.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
