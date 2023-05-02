package com.haninz.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RandomApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationcontext.xml");
	Coach theCoach = context.getBean("myGolfCoach",Coach.class);
	System.out.println(theCoach.getDailyWorkout());
	System.out.println(theCoach.getDailyFortune());

	
	context.close();

	}

}
