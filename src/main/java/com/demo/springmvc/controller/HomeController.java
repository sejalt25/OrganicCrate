package com.demo.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.demo.springmvc.bean.Disease;
import com.demo.springmvc.bean.Patient;
import com.demo.springmvc.bean.User;
import com.demo.springmvc.bean.Vendor;
import com.demo.springmvc.service.DiseaseService;
import com.demo.springmvc.service.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	@Autowired
	private DiseaseService diseaseService;
	
	@GetMapping("/")
	public String forHomePage() {
		return "home";
	}
	
	@GetMapping("/aboutus")
	public String aboutUs() {
		return "aboutus";
	}
	

	@GetMapping("/adminRegistration")
	public String forAdminRegistrationPage(ModelMap model) {
		model.addAttribute("user", new User());
		return "adminRegistration";
	}
	@PostMapping("/adminRegistration")
	public String forAdminRegistrationSave(@ModelAttribute("user") User newAdmin,ModelMap model) {
		if(userService.addAdmin(newAdmin))
			model.addAttribute("msg","Register Success...");
		else
			model.addAttribute("err","Error in registration...");
		return "adminRegistration";
	}
	/*
	 * @RequestMapping(value = "/patient", method = RequestMethod.GET) public String
	 * forAddPatient(Model map) { map.addAttribute("patient", new Patient());
	 * List<Disease> diseaseList = diseaseService.findAll();
	 * map.addAttribute("diseaseList", diseaseList); return "patientInfo"; }
	 */

	@GetMapping("/patientRegistration")
	public String forPatientRegistrationPage(Model map) {
		map.addAttribute("user", new Patient());
		List<Disease> diseaseList = diseaseService.findAll();
		map.addAttribute("diseaseList", diseaseList);
		return "patientRegistration";
	}
	@PostMapping("/patientRegistration")
	public String forPatientRegistrationSave(@ModelAttribute("user") Patient newPatient,ModelMap model) {
		if(userService.addPatient(newPatient))
			model.addAttribute("msg","Register Success...");
		else
			model.addAttribute("err","Error in registration...");
		return "patientRegistration";
	}

	@GetMapping("/vendorRegistration")
	public String forVendorRegistrationPage(ModelMap model) {
		model.addAttribute("user", new Vendor());
		return "vendorRegistration";
	}
	@PostMapping("/vendorRegistration")
	public String forVendorRegistrationSave(@ModelAttribute("user") Vendor newVendor,ModelMap model) {
		if(userService.addVendor(newVendor))
			model.addAttribute("msg","Register Success...");
		else
			model.addAttribute("err","Error in registration...");
		return "vendorRegistration";
	}

	@GetMapping("/userRegistration")
	public String forUserRegistrationPage(ModelMap model) {
		model.addAttribute("user", new User());
		return "userRegistration";
	}
	@PostMapping("/userRegistration")
	public String forUserRegistrationSave(@ModelAttribute("user") User newUser,ModelMap model) {
		if(userService.addUser(newUser))
			model.addAttribute("msg","Register Success...");
		else
			model.addAttribute("err","Error in registration...");
		return "userRegistration";
	}
}
