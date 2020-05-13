package com.example.web.ui.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.web.io.entity.UserEntity;
import com.example.web.service.UserService;

@Controller
public class RegisterController {

	@Autowired
	UserService userService;
	
	@GetMapping("/register")
	public String registerForm(Model model) {
		
		model.addAttribute("user", new UserEntity());
		return "views/registerForm";
	}
	
	@PutMapping("/register")
	public String registerUser(@Valid UserEntity user, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "views/registerForm";
		}
		if(userService.isUserPresent(user.getEmail())) {
			model.addAttribute("exist", true);
			return "views/registerForm";
		}
		
		userService.createUser(user);
		return "views/success";
	}
}
