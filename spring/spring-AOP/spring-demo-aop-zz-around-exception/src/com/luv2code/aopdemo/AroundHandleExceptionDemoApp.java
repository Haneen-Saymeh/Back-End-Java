package com.luv2code.aopdemo;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	
	private static Logger myLogger=Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		// get the  bean from spring container
		
		TrafficFortuneService theService= context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		myLogger.info("running main around demo");
		myLogger.info("calling get fortune");
		boolean flagz=true;
		String fortune=theService.getFortune(flagz);
		myLogger.info("the fortune is: "+fortune);
		myLogger.info("Completed");
		
	
		
		
		// close the context
		
		context.close();
		

	}

}
