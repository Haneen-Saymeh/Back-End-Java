package com.luv2code.springboot.cruddemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	
	@Autowired
	private EmployeeRepository repo;
	
	public List<Employee> findEmployees(){
		return repo.findAll();
	}
	
	public Employee getEmployee(Integer id) {
		Optional<Employee> employee = repo.findById(id);
		Employee theEmployee = null;
		if (employee.isPresent()) {
			theEmployee= employee.get();
		}
		
		else {
			throw new RuntimeException("Employee id not found: "+id);
		}
		
		return theEmployee;
	}
	
	public void deleteEmployee(Integer id) {
		repo.deleteById(id);
	}
	
	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
		
	}

}
