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
		// call the getters and setters for account DAO
		theAccountDAO.setName("local account");
		theAccountDAO.setServiceCode("silver");
		
		String name= theAccountDAO.getName();
		String service = theAccountDAO.getServiceCode();
		
		// call the business method
		Account myAccount = new Account();
		myAccount.setLevel("danger");
		myAccount.setName("international");
		theAccountDAO.addAccount(myAccount,false);
		theMemDao.addAccount();
		theMemDao.addSilly();
		System.out.println(theAccountDAO.addMethdod());
		
		
		
		
		
		// close the context
		
		context.close();
		

	}

}