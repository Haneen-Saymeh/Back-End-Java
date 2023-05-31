package com.haninz.springdemo.restfulweb.entity;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorDetails> handleAllExceptions(Exception exc){
		ErrorDetails error = new ErrorDetails(HttpStatus.BAD_REQUEST.value(),exc.getMessage(),
				LocalDate.now());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler
	public ResponseEntity<ErrorDetails> handleAllExceptions(UserNotFoundResponse exc){
		ErrorDetails error = new ErrorDetails(HttpStatus.NOT_FOUND.value(),exc.getMessage(),
				LocalDate.now());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}

}
