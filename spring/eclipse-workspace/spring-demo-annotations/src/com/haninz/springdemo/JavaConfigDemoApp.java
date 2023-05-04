package com.haninz.springdemo;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(SportConfig.class);
		
		Coach theCoach = context.getBean("chessCoach", Coach.class);
		Coach masterCoach = context.getBean("chessCoach", Coach.class);
		boolean result = (theCoach==masterCoach);
		System.out.println("if the same: "+ result);
		System.out.println("memory ref of the coach: "+ theCoach);
		System.out.println("memory ref of master coach: " + masterCoach);
		context.close();

	}

}
