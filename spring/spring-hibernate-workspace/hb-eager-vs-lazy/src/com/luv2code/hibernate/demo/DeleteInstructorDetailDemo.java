package com.luv2code.hibernate.demo;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

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
			
			
	
			
			

			
		
			// start a transaction
			session.beginTransaction();
		
			int theId =1;
			InstructorDetail intructorDetail = session.get(InstructorDetail.class, theId);
			
			System.out.println("instructor details: " +intructorDetail );
			
			System.out.println("iassociated instructor: " +intructorDetail.getInstructor() );
			// we need to break the associated objects before delete only one of them
			// break bi-directional link
			
			intructorDetail.getInstructor().setInstructorDetail(null);
			// delete instructor details
			session.delete(intructorDetail);
			// commit transaction
			
			session.getTransaction().commit();
			System.out.println("done");
			
			
		}
		

		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
