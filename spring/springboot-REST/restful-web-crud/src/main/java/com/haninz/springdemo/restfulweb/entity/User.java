package com.haninz.springdemo.restfulweb.entity;

import java.time.LocalDate;

public class User {
	
	private String name;
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
