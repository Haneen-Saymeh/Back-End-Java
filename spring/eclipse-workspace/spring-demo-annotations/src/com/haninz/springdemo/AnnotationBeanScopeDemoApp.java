package com.haninz.springdemo;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = context.getBean("chessCoach", Coach.class);
		Coach masterCoach = context.getBean("chessCoach", Coach.class);
		boolean result = (theCoach==masterCoach);
		System.out.println("if the same: "+ result);
		System.out.println("memory ref of the coach: "+ theCoach);
		System.out.println("memory ref of master coach: " + masterCoach);
		context.close();

	}

}
