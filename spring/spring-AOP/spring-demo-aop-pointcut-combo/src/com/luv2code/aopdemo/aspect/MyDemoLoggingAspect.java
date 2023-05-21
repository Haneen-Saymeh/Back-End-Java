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
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void forGettersMethod() {}
	
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void forSetterMethod() {}
	
	@Pointcut("forDAOpackage() && !(forGettersMethod() || forSetterMethod())")
	private void forDAOPackageNotGettersAndSetters() {}
	
	
	
	@Before("forDAOPackageNotGettersAndSetters()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>  executing before advice on method");
	}
	
	
	@Before("forDAOPackageNotGettersAndSetters()")
	public void forAPI() {
		System.out.println("\n=====>  perform some API analytics");
	}

}
