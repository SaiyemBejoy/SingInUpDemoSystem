package com.example.web.ui.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.web.io.entity.UserEntity;
import com.example.web.service.TaskService;
import com.example.web.service.UserService;

@Controller
public class ProfileController {

	@Autowired
	TaskService taskService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/profile")
	public String showProfilePage(Model model, Principal principal) {
		String email = principal.getName();
		UserEntity user = userService.findOne(email);
		
		model.addAttribute("tasks", taskService.findUserTask(user));
		
		return "views/profile";
	}
}
