package com.jinu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jinu.entity.Student;

public class ReadingStudentObject {

	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try{
			//create student 0bject
			System.out.println("Creating new student object...");
			Student std=new Student("Appu","J","roy@appu.com");
			//start transaction
			session.beginTransaction();
			//save the student object
			session.save(std);
			System.out.println("Saving....");
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Saved......");
			
			//Create new session
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			//retrive student based on the student id
			
			System.out.println("Getting student id :"+std.getId());
			
			Student mystudent= session.get(Student.class, std.getId());
			System.out.println("Get complete..."+mystudent);
			//commit the transaction
			session.getTransaction().commit();
			
			
			
		}
		finally{
			factory.close();
		}
		
		

	}

}
