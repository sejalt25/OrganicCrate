package com.demo.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.springmvc.bean.Item;

public interface ItemRepository  extends JpaRepository<Item, Integer> {
	
    
}
