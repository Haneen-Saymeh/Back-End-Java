package com.luv2code.aopdemo;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		// get the  bean from spring container
		
		AccountDAO theAccountDAO= context.getBean("accountDAO",AccountDAO.class);
		
		List <Account> theAccounts =null;
		try {
			// add boolean flag
			boolean flagz= true;
			theAccounts=theAccountDAO.findAccounts(flagz);
		}
		catch(Exception exe) {
			System.out.println("main program caught exeption "+exe);
		}
		System.out.println("------------");
		System.out.println("After throwing demo app");
		System.out.println("-------------");
		System.out.println(theAccounts);
		
		
		// close the context
		
		context.close();
		

	}

}
