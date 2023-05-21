package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	// this is where add all related advices for logging
	
	
	// aspect advice 
	
	@Before("com.luv2code.aopdemo.aspect.AopDeclarations.forDAOPackageNotGettersAndSetters()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n=====>  executing before advice on method");
		
		// display method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("method signature: "+ methodSig);
		
		// display method arguments
		
		Object [] args = theJoinPoint.getArgs();
		
		for (Object arg: args) {
			System.out.println(arg);
			// downcast and print account stuff
			
			if (arg instanceof Account) {
				Account theAccount = (Account) arg;
				System.out.println("Account level: " +theAccount.getLevel());
				System.out.println("Account name: " +theAccount.getName());
				
			}
		}
	}
	

}
