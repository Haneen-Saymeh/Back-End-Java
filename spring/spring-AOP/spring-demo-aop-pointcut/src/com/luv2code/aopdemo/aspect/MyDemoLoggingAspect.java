package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is where add all related advices for logging
	
	// declare point cut variable
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDAOpackage() {}
	
	
	
	@Before("forDAOpackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>  executing before advice on method");
	}
	
	
	@Before("forDAOpackage()")
	public void forAPI() {
		System.out.println("\n=====>  perform some API analytics");
	}

}
