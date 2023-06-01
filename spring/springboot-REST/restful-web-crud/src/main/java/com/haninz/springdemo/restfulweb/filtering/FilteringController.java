package com.haninz.springdemo.restfulweb.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	
	@GetMapping("/filtering")
	public SomeBean getTheBean() {
		return new SomeBean("val1", "val2", "val3");
	}
	
	
	@GetMapping("/filtering-list")
	public List<SomeBean> getThemAllBeans() {
		return Arrays.asList(new SomeBean("val4","val5","val6"),new SomeBean("val7","val8","val9"));
	}

}
