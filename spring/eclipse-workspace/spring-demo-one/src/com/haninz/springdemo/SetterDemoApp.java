package com.haninz.springdemo;
import org.springframework.context.support.*;

public class SetterDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationcontext.xml");
	CricketCoach theCoach = context.getBean("myCricketCoach",CricketCoach.class);
	System.out.println(theCoach.getDailyWorkout());
	System.out.println(theCoach.getDailyFortune());
	
	context.close();

	}

}
