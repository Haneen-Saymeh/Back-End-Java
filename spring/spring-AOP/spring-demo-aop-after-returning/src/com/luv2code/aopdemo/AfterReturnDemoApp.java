package com.luv2code.aopdemo;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterReturnDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		// get the  bean from spring container
		
		AccountDAO theAccountDAO= context.getBean("accountDAO",AccountDAO.class);
		
		List <Account> theAccounts = theAccountDAO.findAccounts();
		System.out.println("the accounts from the main method: " +theAccounts);
		
		
		// close the context
		
		context.close();
		

	}

}
