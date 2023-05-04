package com.haninz.springdemo;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SomeJavaConfigDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(SomeConfig.class);
		
//		Coach theCoach = context.getBean("swimCoach", Coach.class);
		Coach theCoach = context.getBean("someCoach", Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());

		context.close();

	}

}
