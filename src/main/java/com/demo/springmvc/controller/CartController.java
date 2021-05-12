package com.demo.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.springmvc.service.CartService;
import com.demo.springmvc.service.CategoryService;
import com.demo.springmvc.service.ProductService;

@Controller
public class CartController {
	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	CartService cartService;

	@RequestMapping("/user/viewProducts")
	public String forListProduct(ModelMap map, @RequestParam(name = "cid", required = false) long cid) {
		if (cid != 0)
			map.addAttribute("listProducts", productService.findByCid(cid));
		else
			map.addAttribute("listProducts", productService.findAll());
		return "productlist";
	}

	/*
	 * @RequestMapping("/cart/getBill") public String forGetBill(ModelMap
	 * map, @RequestParam(name = "qty") int qty, @RequestParam(name = "pid",required
	 * = false) long pid) { if(pid!=0 && qty!=0) { //Product product =
	 * productService.findByPid(pid); cartService.getBill(pid,qty); } return "cart";
	 * 
	 * 
	 * }
	 */
	
	@RequestMapping("/cart/getBill")
	 public String forGetBill() {
		return "placeorder"	;
	}
}