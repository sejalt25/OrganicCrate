package com.demo.springmvc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.springmvc.bean.Category;
import com.demo.springmvc.bean.Disease;
import com.demo.springmvc.bean.Product;
import com.demo.springmvc.repository.PatientRepository;
import com.demo.springmvc.repository.UserRepository;
import com.demo.springmvc.service.CategoryService;
import com.demo.springmvc.service.DiseaseService;
import com.demo.springmvc.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	DiseaseService diseaseService;
	@Autowired
	UserRepository userRepository;
	@Autowired
	PatientRepository patientRepository;

	@RequestMapping(value = { "/products", "/patient/products" })
	public String forListProduct(ModelMap map, @RequestParam(name = "cid", required = false) Long cid) {
		if (cid != null)
			map.addAttribute("listProducts", productService.findByCid(cid));
		else
			map.addAttribute("listProducts", productService.findAll());
		return "product";
	}
	/*
	 * @RequestMapping(value = { "/products", "/patient/products" }) public String
	 * forListProduct(ModelMap map, @RequestParam(name = "cid", required = false)
	 * Long cid, Principal principal) { String userName = principal.getName();
	 * Patient user = patientRepository.findByEmail(userName);
	 * 
	 * Optional<Disease> optDisease = diseaseService.findByPatient(user); if (cid !=
	 * null) { if (optDisease.isPresent()) map.addAttribute("listProducts",
	 * productService.findByCidAndDid(cid, optDisease.get().getDiseaseId())); else {
	 * map.addAttribute("listProducts", productService.findByCid(cid)); } } else {
	 * map.addAttribute("listProducts", productService.findAll()); } return
	 * "product"; }
	 */

	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_VENDOR')")
	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String forAddProduct(Model map) {
		map.addAttribute("productObj", new Product());
		List<Category> categoryList = categoryService.findAll();
		List<Disease> diseaseList = diseaseService.findAll();
		map.addAttribute("categoryList", categoryList);
		map.addAttribute("diseaseList", diseaseList);
		return "addProduct";
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_VENDOR')")
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String forSaveProduct(@ModelAttribute("productObj") Product product) {
		productService.save(product);
		return "redirect:/products";
	}

	@GetMapping("/disease")
	public String forDisease(Model model) {
		List<Disease> diseaseList = diseaseService.findAll();
		model.addAttribute("diseaseList", diseaseList);
		return "patientInfo";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/editProduct/{id}", method = RequestMethod.GET)
	public String forEditProduct(ModelMap map, @PathVariable Long id) {
		map.addAttribute("command", productService.findById(id));
		return "editProduct";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/editProduct/{id}", method = RequestMethod.POST)
	public String forUpdateProduct(@ModelAttribute("command") Product p) {
		productService.update(p);
		return "redirect:/products";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/deleteProduct/{id}")
	public String forDeleteProduct(@PathVariable Long id) {
		productService.delete(id);
		return "redirect:/products";
	}

	@RequestMapping("/patientProduct")
	public String forListProductPatient(ModelMap map,
			@RequestParam(name = "diseaseId", required = false) Long diseaseId) {
		if (diseaseId != null)
			map.addAttribute("listProducts", productService.findByDiseaseId(diseaseId));
		else
			map.addAttribute("listProducts", productService.findAll());
		return "product";
	}
}
