package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			// update student
			
			int studentId=4;
			Student someStudent = session.get(Student.class, studentId);
			//session.delete(someStudent);
			// another way to delete students
      session.createQuery("delete from Student where id=8").executeUpdate();
		
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
