package com.demo.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.demo.springmvc.bean.Disease;
import com.demo.springmvc.service.DiseaseService;

@Controller
public class DiseaseController {
	@Autowired 
	private DiseaseService diseaseService;

	
	  @GetMapping("/diseasepatient") public String patientProduct(Model model){
	  List<Disease> diseaseList = diseaseService.findAll();
	  model.addAttribute("diseaseList", diseaseList); return "patientRegistration";
	  }
}
