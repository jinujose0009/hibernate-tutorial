package com.jinu.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jinu.entity.Student;

public class QueringObject {

	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try{
			
			//start transaction
			session.beginTransaction();
			
			List<Student> students;
			students=session.createQuery("From Student").list();
			
			getStudentlist(students);
			
			students=session.createQuery("From Student s where s.firstName='Roy' ").list();
			getStudentlist(students);
			
			students=session.createQuery("From Student s where s.firstName='Appu' and "
					+ "s.lastName='J' ").list();
			getStudentlist(students);
			//commit transaction
			session.getTransaction().commit();
			
			
			
			
		}
		finally{
			factory.close();
		}
		
		

	}

	private static void getStudentlist(List<Student> students) {
		for(Student stud:students){
			System.out.println(stud);
		}
	}

}
