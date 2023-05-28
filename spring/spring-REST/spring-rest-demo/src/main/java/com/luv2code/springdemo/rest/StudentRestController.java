package com.luv2code.springdemo.rest;
import java.util.List;

import javax.annotation.PostConstruct;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List <Student> students;
	
	// post construct to load the students data... only once
	
	@PostConstruct
	public void loadData() {
		students = new ArrayList<Student>();
		students.add(new Student("Han", "Sol"));
		students.add(new Student("Tony", "Stark"));
		students.add(new Student("Thor", "Asgard"));
	}
	
	@GetMapping("/students")
	public List <Student> studentsList(){
		
		
		return students;
		
	}
	
	
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id){
		if(id >= students.size() || id < 0) {
			throw new StudentNotFoundException("student id not found: "+ id);
		}
		return students.get(id);
		
	}
	
	// add exception handler use @ExceptionHandler
	
	

}
