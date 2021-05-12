package com.demo.springmvc.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springmvc.bean.Item;
import com.demo.springmvc.bean.Product;
import com.demo.springmvc.repository.ItemRepository;
import com.demo.springmvc.repository.ProductRepository;

import java.util.HashMap;
import java.util.Optional;

@Service
public class CartService {
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ItemRepository itemRepository;
	public void getBill(Long pid, int qty) {
		HttpServletRequest request = null;
        Item item = getItem(pid,qty);
		HttpSession session = request.getSession();
		HashMap<Long,Item> blist = null;
		if(session.getAttribute("bill")==null) {
			blist=new HashMap<>();
		}
		else {
			blist =(HashMap<Long, Item>) session.getAttribute("bill");

		}
		blist.put(pid,item);
		session.setAttribute("bill", blist);

	}
	private Item getItem(long pid,int qty) {
		Optional<Product> product = productRepository.findByPid(pid);
		Item item =new Item();
		if(product.isPresent()) {
			item.setName(product.get().getPname());
			item.setQty(qty);
			item.setPrice(product.get().getPrice());
			itemRepository.save(item);
		}
		return item;
	}
	

	}
	
