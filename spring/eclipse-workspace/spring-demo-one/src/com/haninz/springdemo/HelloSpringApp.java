package com.haninz.springdemo;
import org.springframework.context.support.*;

public class HelloSpringApp {

	public static void main(String[] args) {
//		load the spring configuration file
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("applicationContext.xml");
//   retrieve the bean from the container
		Coach theCoach = context.getBean("mycoach", Coach.class);
//		call the method on the  bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
//		close the context
		context.close();
	}

}
