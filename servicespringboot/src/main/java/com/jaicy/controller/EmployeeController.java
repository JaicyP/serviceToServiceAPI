package com.jaicy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaicy.entity.Employee;
import com.jaicy.service.EmployeeService;

@RestController()
@RequestMapping("/employee")
public class EmployeeController {
	
	
	@Autowired
	EmployeeService employeeService;
	
	
	@PostMapping("/addEmployee")
	public String register(@RequestBody Employee e){
		Employee emp=employeeService.register(e);
		if(emp!=null) {
			return "ok";
		}
		return "notOk";
	}
	
	@GetMapping("/show/{id}")
	public Employee display(@PathVariable int id){
		return employeeService.display(id);
	}

}

