package com.haninz.springdemo.restfulweb.entity;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {
	
	@Size(min=3, message="should have at least 3 characters")
	private String name;
	
	@Past(message="Birth date should be in the past!")
	private LocalDate birthDate;
	
	
	public User() {
		
	}


	public User(String name, LocalDate birthDate) {
		
		this.name = name;
		this.birthDate = birthDate;
	}





	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}


	@Override
	public String toString() {
		return "User [name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	
	

}
