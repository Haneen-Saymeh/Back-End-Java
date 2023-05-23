package com.luv2code.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	// setup logger
	private Logger myLogger= Logger.getLogger(getClass().getTypeName());
	
	// add pointcut declaration
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {
		
	}
	
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {
		
	}
	
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDAOPackage() {
		
	}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {
		
	}
	// add @Before advice
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("===> in @Before calling: "+ method);
		
		Object [] args= theJoinPoint.getArgs();
		for(Object arg : args) {
			myLogger.info("===> arguments: "+ arg);
		}
	}
	
	
	// add @After advice
	
	@AfterReturning(pointcut="forAppFlow()", returning="theResult")
	public void afterMethod(JoinPoint theJoinPoint, Object theResult) {
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("===> in @AfterReturning from method : "+ method);
		
		// display data returned 
		myLogger.info("===> result: "+ theResult);
		
	}

}
