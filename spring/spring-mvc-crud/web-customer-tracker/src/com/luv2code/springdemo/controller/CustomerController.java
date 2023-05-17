package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// autowired will  scan for components that implements dao interface
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model model) {
		
		// get the costumer from dao
		List <Customer> customers = customerService.getCustomers();
		// add cutomer to the model
		
		model.addAttribute("customers", customers);
		
		return "customer-list";
		
	}
	
	@GetMapping("/form")
	public String addForm(Model model) {
		Customer customer =new Customer();
		model.addAttribute("customer", customer);
		return "customer-form";
	}
	
	@PostMapping("/add")
	public String addCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	
	@GetMapping("/{id}")
	public String updateForm(@PathVariable("id") int id, Model model) {
		// get the customer from database
		Customer theCustomer = customerService.getCustomer(id);
		model.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	
	@GetMapping("/del/{id}")
	public String deleteCustomer(@PathVariable("id") int id) {
		Customer theCustomer = customerService.getCustomer(id);
		customerService.deleteCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}

}
