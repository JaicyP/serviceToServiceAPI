package com.jaicy.dao;

import org.springframework.data.repository.CrudRepository;

import com.jaicy.entity.Employee;

public interface EmployeeDao extends CrudRepository<Employee,Integer>{

}
