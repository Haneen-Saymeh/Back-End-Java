package com.haninz.springdemo.restfulweb.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World!!!";
	}
	
	
	@GetMapping("/hello-bean")
	public HelloBean sayHelloBean() {
		return new HelloBean("Hiiiz !!!");
	}
	
	
	@GetMapping("/hello-bean/{name}")
	public HelloBean sayHelloBeanPath(@PathVariable String name) {
		return new HelloBean("Yooo !!! "+ name);
	}


}
