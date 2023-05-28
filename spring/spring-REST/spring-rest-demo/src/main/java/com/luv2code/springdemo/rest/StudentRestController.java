package com.luv2code.springdemo.rest;
import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	@GetMapping("/students")
	public List <Student> studentsList(){
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student("Han", "Sol"));
		students.add(new Student("Tony", "Stark"));
		students.add(new Student("Thor", "Asgard"));
		
		return students;
		
	}

}
