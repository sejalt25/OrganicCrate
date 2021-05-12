package com.demo.springmvc.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.springmvc.bean.Disease;
import com.demo.springmvc.bean.Patient;
import com.demo.springmvc.repository.PatientRepository;
import com.demo.springmvc.repository.UserRepository;
import com.demo.springmvc.service.CategoryService;
import com.demo.springmvc.service.DiseaseService;
import com.demo.springmvc.service.ProductService;

@Controller
@RequestMapping("/patient")
public class PatientController {
	@Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private DiseaseService diseaseService;
   
    @Autowired
    private PatientRepository patientRepository;

	@PreAuthorize("hasRole('ROLE_PATIENT')")
	@GetMapping
	public String forPatientHome() {
		return "patientHome";
	}
	
	@RequestMapping("/patient/products")
    public String forListProduct(ModelMap map, @RequestParam(name = "cid", required = false) Long cid,Principal principal) {
        String userName=principal.getName();
        Patient user = patientRepository.findByEmail(userName);
        
        Optional<Disease> optDisease = diseaseService.findByPatient(user);
    	if (cid != null) {
    		if(optDisease.isPresent())
    			map.addAttribute("listProducts", productService.findByCidAndDid(cid,optDisease.get().getDiseaseId()));
    		else
    			map.addAttribute("listProducts", productService.findByCid(cid));
    	}
        else
            map.addAttribute("listProducts", productService.findAll());
        return "product";
    }
	
}