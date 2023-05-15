package com.luv2code.hibernate.demo;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Course;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndReviewDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		// use session object to save java object
		try {
			
			
			
			
			
		
			// start a transaction
			session.beginTransaction();
			
		// create course 
			Course newCourse = new Course("database");
			Review rev1= new Review("this course is masterpeace!");
			Review rev2= new Review("good stuff!");
			Review rev3= new Review("not that bad!");
			
			newCourse.addReview(rev1);
			newCourse.addReview(rev2);
			newCourse.addReview(rev3);
			
			session.save(newCourse);
			
			
			
		
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