package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAspect {
	
	@Before("com.luv2code.aopdemo.aspect.AopDeclarations.forDAOPackageNotGettersAndSetters()")
	public void forAPI() {
		System.out.println("\n=====>  perform some API analytics");
	}

}
