package com.haninz.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
		Coach chessMaster= context.getBean("chessCoach", Coach.class);
		
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(chessMaster.getDailyWorkout());
		System.out.println(chessMaster.getDailyFortune());
	
	
		context.close();

	}

}
