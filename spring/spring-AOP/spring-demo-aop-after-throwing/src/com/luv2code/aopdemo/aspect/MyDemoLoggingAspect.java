package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	@AfterThrowing(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		String method=theJoinPoint.getSignature().toShortString();
		System.out.println("===> Excecuting @AfterTHrowing method  "+method);
		System.out.println("The execption is: "+theExc);
	}
	
	// add new advice for after returning for find accounts method
	
	@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		String method = theJoinPoint.getSignature().toShortString();
		// print out which method we are advicing on 
		System.out.println("===> executing after returning on method: "+ method);
		
		// print out the results of the method call
		System.out.println("===> result is: "+ result);
		
		// modefy result
		
		updateResultNamesToUpperCase(result);
		
		System.out.println("===> result is: "+ result);
		
	}
	
	
	private void updateResultNamesToUpperCase(List<Account> result) {
		for (Account one: result) {
			String newName=one.getName().toUpperCase();
			one.setName(newName);
			
			
		}
		
	}


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
