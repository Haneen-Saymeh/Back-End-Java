package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	// this is where add all related advices for logging
	
	
	// aspect advice 
	
	@Before("com.luv2code.aopdemo.aspect.AopDeclarations.forDAOPackageNotGettersAndSetters()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>  executing before advice on method");
	}
	

}
