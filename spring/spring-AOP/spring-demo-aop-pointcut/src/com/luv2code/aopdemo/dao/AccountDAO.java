package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

// this to create target object

@Component
public class AccountDAO {
	
	public void addAccount(Account account, Boolean flag) {
		System.out.println(getClass()+ " : doing my DB work: adding account for AccountDAO class");
	}
	
	public String addMethdod() {
		return "return type method of String";
		
	}

}
