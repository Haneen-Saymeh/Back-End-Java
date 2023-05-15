package com.luv2code.hibernate.demo;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Course;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCoursesDemo {

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
			
			
			// create student object
			System.out.println("creating instructor object");
			
			
		
			// start a transaction
			session.beginTransaction();
			
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			Course course1 = new Course("Java");
			Course course2 = new Course("Python");
			
			tempInstructor.addCourses(course1);
			tempInstructor.addCourses(course2);
			
			session.save(course1);
			session.save(course2);
			
			
		
			// commit transaction
			
			session.getTransaction().commit();
			System.out.println("done");
			
		}
		finally {
			// add clean up code
			session.close();
			factory.close();
		}

	}

}
