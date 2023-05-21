package com.luv2code.aopdemo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		// get the  bean from spring container
		
		AccountDAO theAccountDAO= context.getBean("accountDAO",AccountDAO.class);
		MembershipDAO theMemDao = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method
		theAccountDAO.addAccount(new Account(),false);
		theMemDao.addAccount();
		theMemDao.addSilly();
		System.out.println(theAccountDAO.addMethdod());
		
		
		
		
		
		// close the context
		
		context.close();
		

	}

}
