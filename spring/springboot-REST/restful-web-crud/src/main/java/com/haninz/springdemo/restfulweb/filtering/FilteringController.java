package com.haninz.springdemo.restfulweb.filtering;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.databind.ser.FilterProvider;



@RestController
public class FilteringController {
	
	
	@GetMapping("/filtering")
	public MappingJacksonValue getTheBean() {
		SomeBean bean= new SomeBean("val1", "val2", "val3");
		MappingJacksonValue mapping = new MappingJacksonValue(bean);
		SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("somebeanfilter", filter);
        mapping.setFilters(filters);

		return mapping;
	}
	
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue getThemAllBeans() {
		List<SomeBean> beans= new ArrayList<>();
		beans.add(new SomeBean("val4","val5","val6"));
		beans.add(new SomeBean("val7","val8","val9"));
		MappingJacksonValue mapping = new MappingJacksonValue(beans);
		SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("somebeanfilter", filter);
        mapping.setFilters(filters);
		
		return mapping;
	}

}
