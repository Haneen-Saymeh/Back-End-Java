package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		// use session object to save java object
		try {
			
			
			// create student object
			System.out.println("creating student object");
			Student tempStudent = new Student("Daffy", "Duck", "daffy@sth.com");
			// start a transaction
			session.beginTransaction();
			// save the student object
			System.out.println("save the studen object");
			System.out.println(tempStudent);
			session.save(tempStudent);
			// commit transaction
			
			session.getTransaction().commit();
			
			// new code for reading object after creating
			// finding out the new object generated id:
			System.out.println("new student's id: "+ tempStudent.getId());
			
			// get new session and start transaction: 
			session = factory.getCurrentSession();
			session.beginTransaction();
			// retrieve student based on its id-- primary key
			System.out.println("getting student via id: "+ tempStudent.getId());
			Student newStudent = session.get(Student.class, tempStudent.getId());
			System.out.println(newStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("done");
			
		}
		finally {
			factory.close();
		}

	}

}
