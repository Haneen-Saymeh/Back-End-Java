package com.luv2code.hibernate.demo;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Course;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.hibernate.demo.entity.Student;

public class EagerLazyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		// use session object to save java object
		try {
			
			
		
			// start a transaction
			session.beginTransaction();
			
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("luv2code, instructor: "+tempInstructor );
			// option 1 use session. get with getter method
			// resolve the issue by using getter method while session is open
			// the other getter method after closing session will work,cuz it's already loaded
			System.out.println("luv2code, courses: "+tempInstructor.getCourses());
			
			
		
			// commit transaction
			
			session.getTransaction().commit();
			session.close();
			System.out.println("session has been closed!");
			// this will through an exception as the session is closed, lazy loading needs an open session
			// resovle the issue by option 1
			System.out.println("luv2code, courses: "+tempInstructor.getCourses());
			System.out.println("luv2code, done");
			
		}
		finally {
			// add clean up code
			session.close();
			factory.close();
		}

	}

}
