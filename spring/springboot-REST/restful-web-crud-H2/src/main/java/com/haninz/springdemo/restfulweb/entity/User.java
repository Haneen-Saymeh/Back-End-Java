package com.haninz.springdemo.restfulweb.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name="user_details")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	@Size(min=3, message="should have at least 3 characters")
	@JsonProperty("user_name")
	private String name;
	
	@Past(message="Birth date should be in the past!")
	@JsonProperty("birth_date")
	private LocalDate birthDate;
	
	@OneToMany(mappedBy="user")
	private List<Post> posts;
	
	
	public User() {
		
	}


	public User(String name, LocalDate birthDate) {
		
		this.name = name;
		this.birthDate = birthDate;
	}





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}


	
	
	
	

}
