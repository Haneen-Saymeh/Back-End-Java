package com.haninz.springdemo.restfulweb.entity;

import java.time.LocalDate;

public class ErrorDetails {
	
	private int status;
	private String message;
	private LocalDate timeStamp;
	
	public ErrorDetails() {
		
	}

	public ErrorDetails(int status, String message, LocalDate timeStamp) {
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDate getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDate timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
	
	
	

}
