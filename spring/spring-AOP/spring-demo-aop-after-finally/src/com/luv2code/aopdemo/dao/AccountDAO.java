package com.luv2code.aopdemo.dao;

import java.util.List;
import java.util.ArrayList;

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
	
	public List<Account> findAccounts(boolean flag){
		// simulating exception
		// mean if flag==true
		if(flag) {
			throw new RuntimeException("no account for you");
		}
		List<Account> myAccounts = new ArrayList();
		
		Account account1 = new Account("Marvel","Gold");
		Account account2 = new Account("DC","Silver");
		Account account3 = new Account("Disney","Bronze");
		
		myAccounts.add(account1);
		myAccounts.add(account2);
		myAccounts.add(account3);
		
		return myAccounts;
	}



	@Override
	public String toString() {
		return "AccountDAO [name=" + name + ", serviceCode=" + serviceCode + "]";
	}
	
	

}
