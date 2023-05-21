package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

// this to create target object

@Component
public class AccountDAO {
	private String name;
	private String serviceCode;
	
	
	
	
	public String getName() {
		System.out.println(getClass()+ " : in get name");
		return name;
		
	}

	public void setName(String name) {
		System.out.println(getClass()+ " : in set name");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+ " : in get service");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+ " : in set service");
		this.serviceCode = serviceCode;
	}

	public void addAccount(Account account, Boolean flag) {
		System.out.println(getClass()+ " : doing my DB work: adding account for AccountDAO class");
	}
	
	public String addMethdod() {
		return "return type method of String";
		
	}

}
