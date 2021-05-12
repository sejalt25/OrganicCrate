package com.demo.springmvc.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vendor")
public class VendorController {
	
	@PreAuthorize("hasRole('ROLE_VENDOR')")
	@GetMapping
	public String forVendorHome() {
		return "vendorHome";
	}
	
}