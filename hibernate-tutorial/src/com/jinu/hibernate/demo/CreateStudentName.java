package com.jinu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jinu.entity.Student;

public class CreateStudentName {

	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try{
			//create student 0bject
			System.out.println("Creating new student object");
			Student std=new Student("Roy","K","roy@gmail.com");
			//start transaction
			session.beginTransaction();
			//save the student object
			session.save(std);
			//commit transaction
			session.getTransaction().commit();
			
		}
		finally{
			factory.close();
		}
		
		

	}

}
