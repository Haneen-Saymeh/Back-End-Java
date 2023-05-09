package com.luv2code.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;



@Controller
@RequestMapping("/customer")
public class CustomerController {
	// add an initbinder ... to convert trim input strings
		// remove leading and trailing whitespace
		// resolve issue for our validation, for accepting white spaces
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		// true means make it null if all spaces
		StringTrimmerEditor stringTrimmer = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmer);
		
	}
	
	@RequestMapping("/form")
	public String showForm(Model model) {
		
		model.addAttribute("customer",new Customer());
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, 
			BindingResult theBindingResult) {
		if(theBindingResult.hasErrors()) {
			return "customer-form";
		}
		
		else {
			return "customer-confirm";
		}
		
		
	}

}
