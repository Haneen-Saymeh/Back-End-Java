package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
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
			Student tempStudent1 = new Student("Yogi", "Yo", "sth@sth.com");
			Student tempStudent2 = new Student("Tony", "Stark", "sth@sth.com");
			Student tempStudent3 = new Student("Natasha", "Romanof", "sth@sth.com");
			// start a transaction
			session.beginTransaction();
			// save the student object
			System.out.println("save the studen object");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			// commit transaction
			
			session.getTransaction().commit();
			System.out.println("done");
			
		}
		finally {
			factory.close();
		}

	}

}
