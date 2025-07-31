package com.jaicy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jaicy.entity.Employee;
import com.jaicy.service.HomeService;

@Controller
public class HomeController {
	
	@Autowired
	HomeService homeService;
	
	@RequestMapping("/register")
	public String registerPage() {
		return "register";
	}
	
	@PostMapping("/registerEmployee")
	public String registerEmployee(@ModelAttribute Employee emp) {
		boolean isAdded=homeService.register(emp);
		if(isAdded) {
			return "result";
		}else {
			return "error";
		}
		
	}
	
	@GetMapping("/display/{id}")
	public String getEmployee(@PathVariable int id,Model m) {
		Employee e=homeService.getEmployee(id);
		m.addAttribute("employee", e);
		return "displayAll";
	}

}
