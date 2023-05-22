package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJP) throws Throwable {
		
		// print method we advice on
		String method=proceedingJP.getSignature().toShortString();
		myLogger.info("===> Excecuting @Around  method  "+method);
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		
		// execute target method
		Object result = null;
		
		try {
			result=proceedingJP.proceed();
		} catch (Throwable e) {
			// log the exception
			myLogger.warning(e.getMessage());
			
			// give a user a custom message
//			result="Major accident!, but help is on the way";
			throw e;
		
		}
		
		// get end time stamp
		long end = System.currentTimeMillis();
		// duration
		long duration= end - begin;
		myLogger.info("the duration is: " + duration/1000.0 +" seconds");
		return result;
	}
	
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		String method=theJoinPoint.getSignature().toShortString();
		myLogger.info("===> Excecuting @After finally method  "+method);
		
	}
	
	@AfterThrowing(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		String method=theJoinPoint.getSignature().toShortString();
		myLogger.info("===> Excecuting @AfterTHrowing method  "+method);
		myLogger.info("The execption is: "+theExc);
	}
	
	// add new advice for after returning for find accounts method
	
	@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		String method = theJoinPoint.getSignature().toShortString();
		// print out which method we are advicing on 
		myLogger.info("===> executing after returning on method: "+ method);
		
		// print out the results of the method call
		myLogger.info("===> result is: "+ result);
		
		// modefy result
		
		updateResultNamesToUpperCase(result);
		
		myLogger.info("===> result is: "+ result);
		
	}
	
	
	private void updateResultNamesToUpperCase(List<Account> result) {
		for (Account one: result) {
			String newName=one.getName().toUpperCase();
			one.setName(newName);
			
			
		}
		
	}


	@Before("com.luv2code.aopdemo.aspect.AopDeclarations.forDAOPackageNotGettersAndSetters()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n=====>  executing before advice on method");
		
		// display method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info("method signature: "+ methodSig);
		
		// display method arguments
		
		Object [] args = theJoinPoint.getArgs();
		
		for (Object arg: args) {
			myLogger.info(arg.toString());
			// downcast and print account stuff
			
			if (arg instanceof Account) {
				Account theAccount = (Account) arg;
				myLogger.info("Account level: " +theAccount.getLevel());
				myLogger.info("Account name: " +theAccount.getName());
				
			}
		}
	}
	

}
