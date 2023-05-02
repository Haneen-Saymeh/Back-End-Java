package com.haninz.springdemo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		// this singleton, both have same reference to the same bean!!!
		/// when we change to prototype both don't refer to same objects
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		// check if they're the same
		boolean result = (theCoach==alphaCoach);
		System.out.println("is it same? "+ result);
		System.out.println("memory location for the: "+ theCoach);
		System.out.println("memory location for alpha: "+ alphaCoach);
		context.close();

	}

}
