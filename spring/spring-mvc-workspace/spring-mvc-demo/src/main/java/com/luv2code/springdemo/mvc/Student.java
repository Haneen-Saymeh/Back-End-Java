package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	private String firstName;
	private String lastName;
	private String country;
	private LinkedHashMap <String, String> countryOptions;
	private String favoriteLang;
	private String[] operatingSystems;
	
	public Student() {
		countryOptions= new LinkedHashMap<>();
		countryOptions.put("Br", "Brazil");
		countryOptions.put("Fr", "France");
		countryOptions.put("De", "Germany");
		
		
		
	}
	
	// getters when loading the form
	// setters when submitting the form

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
    
	
	// for this we only need the getter, because we use it when loading the form. 
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
		this.countryOptions = countryOptions;
	}

	public String getFavoriteLang() {
		return favoriteLang;
	}

	public void setFavoriteLang(String favoriteLang) {
		this.favoriteLang = favoriteLang;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	
	
	
	
	
	
	
	
	
	

}
