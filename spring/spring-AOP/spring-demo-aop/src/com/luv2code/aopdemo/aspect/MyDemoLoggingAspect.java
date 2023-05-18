package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is where add all related advices for logging
	
	// do an @Before advice
	
	
	// run this code before ==> target object method==> addAccount
	// between brackets is pointcut means it specefy where aspect advice will be applied
	// match any method called addAccount in any class
//	@Before("execution(public void addAccount())")
	
	// only to match add account method in AccountDAO class 
//	@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
	
	// match on any method that starts with add in any class
//	@Before("execution(public void add*())")
	// match on return type of anytype
//	@Before("execution(* add*())")
	// match param of type account
	//@Before("execution(* add*(com.luv2code.aopdemo.Account))")
	// match on param type of account and any number of params
	//@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")
	// matches any params
//	@Before("execution(* add*(..))")
	// matches the package, with any class and any method inside the package
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>  executing before advice on method");
	}

}
