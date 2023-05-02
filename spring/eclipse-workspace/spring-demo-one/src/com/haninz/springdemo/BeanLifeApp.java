package com.haninz.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLife-applicationContext.xml");
		Coach theCoach = context.getBean("myCoach", Coach.class);
	System.out.println(theCoach.getDailyWorkout());
		context.close();

	}

}
