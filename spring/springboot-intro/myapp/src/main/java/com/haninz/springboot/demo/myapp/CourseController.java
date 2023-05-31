package com.haninz.springboot.demo.myapp;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@GetMapping("/courses")
	public List<Course> coursesList(){
		Course c1=new Course(1,"Java", "han");
		Course c2=new Course(2,"Python","someone");
		ArrayList <Course> courses= new ArrayList<>();
		courses.add(c2);
		courses.add(c1);
		return courses;
	}

}
