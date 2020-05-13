package com.example.web.ui.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.web.io.entity.TaskEntity;
import com.example.web.service.TaskService;
import com.example.web.service.UserService;

@Controller
public class TaskController {

	@Autowired
	TaskService taskService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/addTask")
	public String taskForm(String email, Model model, HttpSession session) {
		session.setAttribute("email", email);
		
		model.addAttribute("task", new TaskEntity());
		return "views/taskForm";
	}
	
	@PutMapping("/addTask")
	public String addTask(TaskEntity task, BindingResult bindingResult, HttpSession session) {
		if(bindingResult.hasErrors()) {
			return "views/taskForm";
		}
		
		String email = (String) session.getAttribute("email");
		taskService.addTask(task, userService.findOne(email));
		
		return "redirect:/users";
	}
}
