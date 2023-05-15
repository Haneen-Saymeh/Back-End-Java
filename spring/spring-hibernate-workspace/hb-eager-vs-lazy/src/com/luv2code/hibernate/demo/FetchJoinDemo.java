package com.luv2code.hibernate.demo;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Course;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Student;

public class FetchJoinDemo {

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
			// option 2 hibernate query with HQL
			
			// get instructor and its courses from db
			Query<Instructor> query= session.createQuery("select i from instructor i JOIN FETCH i.courses where i.id=:theInstructorId");
			
			// set parameters on query
			query.setParameter("theInstructorId", theId);
			// execute query and get instructor 
			Instructor tempIns=query.getSingleResult();
			
			System.out.println("instructor and courses: "+tempIns );
			
		
			// commit transaction
			
			session.getTransaction().commit();
			session.close();
			System.out.println("session has been closed!");
			// this will through an exception as the session is closed, lazy loading needs an open session
			// resovle the issue by option 2
			System.out.println("luv2code, courses: "+tempIns.getCourses());
			System.out.println("luv2code, done");
			
		}
		finally {
			// add clean up code
			session.close();
			factory.close();
		}

	}

}
