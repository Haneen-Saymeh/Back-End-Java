package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/form")
	public String showForm(Model model) {
		// create student object
		Student theStudent = new Student();
		
		// add student object to the model
		model.addAttribute("student",theStudent);
		
		return "student-form";
	}
	
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		
		System.out.println("the student name is: " + theStudent.getFirstName()+" " +
		theStudent.getLastName());
		
		return "student-confirmation";
	}
	
	

}
