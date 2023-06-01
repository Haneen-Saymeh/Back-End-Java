package com.haninz.springdemo.restfulweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haninz.springdemo.restfulweb.entity.Name;
import com.haninz.springdemo.restfulweb.entity.PersonV1;
import com.haninz.springdemo.restfulweb.entity.PersonV2;

@RestController
public class VersioningController {
	
	
	// uri versioning
	@GetMapping("/v1/person")
	public PersonV1 getPersonV1() {
		return new PersonV1("Tony Stark");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getPersonV2() {
		return new PersonV2(new Name("Tony", "Stark"));
	}
	
	
	@GetMapping(path="/person", params="version=1")
	public PersonV1 getVersion1() {
		return new PersonV1("Tony Stark");
	}
	
	
	@GetMapping(path="/person", params="version=2")
	public PersonV2 getVersion2() {
		return new PersonV2(new Name("Tony", "Stark"));
	}

}
