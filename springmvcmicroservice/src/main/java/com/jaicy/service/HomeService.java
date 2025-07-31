package com.jaicy.service;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.jaicy.entity.Employee;





@Service
public class HomeService {
	
	public boolean register(Employee emp) {
		RestTemplate template = new RestTemplate();
		String url="http://localhost:8181/employee/addEmployee";
		
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		header.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Employee> reqEntity = new HttpEntity<Employee>(emp,header);
		template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
	    
        ResponseEntity<String> resEntity = template.exchange(url, HttpMethod.POST, reqEntity, String.class);
		
		if(resEntity.getBody().equals("ok")) {
			return true;
		}
		
	   return false;
	}
	
	public Employee getEmployee(int id) {
		
		RestTemplate template=new RestTemplate();
		String url="http://localhost:8181/employee/show/"+id;
		
		HttpHeaders header=new HttpHeaders();
		
		HttpEntity<String> reqEntity =  new HttpEntity<String>(url,header);
	    
		ResponseEntity<Employee> resEntity = template.exchange(url, HttpMethod.GET, reqEntity, Employee.class);
		

		Employee e = resEntity.getBody();
		
		return e;
		
	}
	
	

}
