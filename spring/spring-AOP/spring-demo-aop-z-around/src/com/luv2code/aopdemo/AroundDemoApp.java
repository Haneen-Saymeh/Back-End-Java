package com.luv2code.aopdemo;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		// get the  bean from spring container
		
		TrafficFortuneService theService= context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		System.out.println("running main around demo");
		System.out.println("calling get fortune");
		String fortune=theService.getFortune();
		System.out.println("the fortune is: "+fortune);
		System.out.println("Completed");
		
	
		
		
		// close the context
		
		context.close();
		

	}

}
