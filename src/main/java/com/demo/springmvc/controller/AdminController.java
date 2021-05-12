package com.demo.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.springmvc.bean.User;
import com.demo.springmvc.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService userService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping
	public String forAdminHome() {
		return "adminHome";
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/users")
	public String forUsersPage(ModelMap model) {
		List<User> userList = userService.findAll();
		model.addAttribute("userList", userList);
		return "allUsers";
	}
	
}