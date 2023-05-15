package com.luv2code.hibernate.demo;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		// use session object to save java object
		try {
			
			
			// create student object
			System.out.println("creating instructor object");
			//Instructor tempInstructor = new Instructor("Chad", "Darby", "chad@luv2code.com");
			
			//InstructorDetail tempDetail = new InstructorDetail("luv2code", "coding");
			
			
Instructor tempInstructor = new Instructor("Han", "Sol", "han@luv2code.com");
			
			InstructorDetail tempDetail = new InstructorDetail("techiePengyou", "coding");
			
			// associate the objects
			
			tempInstructor.setInstructorDetail(tempDetail);
			
			// start a transaction
			session.beginTransaction();
			// save the student object
			System.out.println("save the instructor object");
			// this will save instrucotr object and instructor detail object because of cascade
			session.save(tempInstructor);
			// commit transaction
			
			session.getTransaction().commit();
			System.out.println("done");
			
		}
		finally {
			factory.close();
		}

	}

}
