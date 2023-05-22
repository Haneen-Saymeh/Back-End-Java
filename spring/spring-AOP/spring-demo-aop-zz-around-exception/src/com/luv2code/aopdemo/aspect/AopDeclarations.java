package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopDeclarations {
	
	// declare point cut variable
	
		@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
		public void forDAOpackage() {}
		
		@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
		public void forGettersMethod() {}
		
		
		@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
		public void forSetterMethod() {}
		
		@Pointcut("forDAOpackage() && !(forGettersMethod() || forSetterMethod())")
		public void forDAOPackageNotGettersAndSetters() {}
		

}
