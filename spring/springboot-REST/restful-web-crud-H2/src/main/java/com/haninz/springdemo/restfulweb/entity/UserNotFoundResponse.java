package com.haninz.springdemo.restfulweb.entity;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class UserNotFoundResponse extends RuntimeException {
	

	

	public UserNotFoundResponse(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	

}
