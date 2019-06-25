package com.jinu.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jinu.entity.Student;

public class UpdateequeryDemo {

	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try{
			int stid=5;
			
			//start transaction
			session.beginTransaction();
			
			Student mystud=session.get(Student.class,stid);
			mystud.setFirstName("Test");
			session.getTransaction().commit();
			
			System.out.println("Updated.....");
			//New code...
			session=factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set firstName='test1' where id="+stid).executeUpdate();
			session.getTransaction().commit();
			
			
		}
		finally{
			factory.close();
		}
	}
}
