package com.luv2code.springboot.cruddemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.services.EmployeeService;

@RestController
public class HomeController {
	@Autowired
	private EmployeeService service;
	
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return service.findEmployees();
	}
	
	
	@GetMapping("/employees/{id}")
	public Employee getOneEmployee(@PathVariable int id) {
		return service.getEmployee(id);
		
	}
	
	
	@DeleteMapping("/employees/{id}")
	public String delOneEmployee(@PathVariable int id) {
		 service.deleteEmployee(id);
		 return "Employee has been deleted" + id;
		
	}
	
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee){
		 return service.saveEmployee(employee);
	}
	
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee){
		 return service.saveEmployee(employee);
	}

}
