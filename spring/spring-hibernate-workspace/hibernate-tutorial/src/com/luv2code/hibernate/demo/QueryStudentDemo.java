package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

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
			
			
			// start a transaction
			session.beginTransaction();
			
			// query students
			List <Student> students= session.createQuery("from Student").list();
			
			// display students
			displayStudents(students);
			
			
			List <Student> yoStudents = session.createQuery("from Student s where s.lastName='Yo'").list();
			System.out.println("Students of last name Yo!!!");
			displayStudents(yoStudents);
			
			List<Student> someStudents=
					session.createQuery("from Student s where s.lastName='Sol' or s.firstName='Tony'").list();
			displayStudents(someStudents);
			
			List<Student> moreStudents=
					session.createQuery("from Student s where s.email  LIKE '%sth.com'").list();
			displayStudents(moreStudents);
		
			// commit transaction
			
			session.getTransaction().commit();
			System.out.println("done");
			
		}
		finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> students) {
		for(Student student: students) {
			System.out.println(student);
		}
	}

}
