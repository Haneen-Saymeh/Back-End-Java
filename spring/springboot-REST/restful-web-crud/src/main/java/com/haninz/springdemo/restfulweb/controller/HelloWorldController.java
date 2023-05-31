package com.haninz.springdemo.restfulweb.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
	
	@GetMapping("/hello")
	public String sayHello() {
		Locale locale=LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null,"Default Message", locale);
		
	}

}
