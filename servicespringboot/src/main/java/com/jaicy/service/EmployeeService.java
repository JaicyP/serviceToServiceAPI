package com.jaicy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.jaicy.dao.EmployeeDao;
import com.jaicy.entity.Employee;

@Service
public class EmployeeService {
	
	
	@Autowired
	EmployeeDao employeeDao;
	
	public Employee register(Employee e) {
		return employeeDao.save(e);
	}
	
	public Employee display(int id){
		Optional<Employee> emp=employeeDao.findById(id);
		return emp.get();
	}

}
