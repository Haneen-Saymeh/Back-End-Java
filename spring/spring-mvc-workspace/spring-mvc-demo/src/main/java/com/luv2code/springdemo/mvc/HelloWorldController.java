package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("hey")
public class HelloWorldController {
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "form-page";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "result";
	}
	
	@RequestMapping("/processFormAgain")
	public String shoutDude(HttpServletRequest request, Model model) {
		String theName = request.getParameter("studentName");
		theName= theName.toUpperCase();
		String sentence = "Yo! " + theName;
		model.addAttribute("message", sentence);
		return "result";
	}
	
	
	@RequestMapping("/processFormAgainAgain")
	public String shoutDudeNew(@RequestParam("studentName") String theName, Model model) {
		
		theName= theName.toUpperCase();
		String sentence = "Hey, My friend " + theName;
		model.addAttribute("message", sentence);
		return "result";
	}

}
