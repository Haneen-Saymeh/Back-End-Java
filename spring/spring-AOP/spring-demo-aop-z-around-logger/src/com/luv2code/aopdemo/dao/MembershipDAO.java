package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addAccount() {
		System.out.println(getClass()+ " adding account for MembershipDAO class");
	}
	
	public void addSilly() {
		System.out.println(getClass() + " inside silly method ");
	}

}
