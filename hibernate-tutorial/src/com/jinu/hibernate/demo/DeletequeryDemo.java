package com.jinu.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jinu.entity.Student;

public class DeletequeryDemo {

	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try{
			int stid=3;
			
			//start transaction
			session.beginTransaction();
			
			Student mystud=session.get(Student.class,stid);
			
			session.delete(mystud);
			session.getTransaction().commit();
			
			System.out.println("Deleted.....");
			//New code...
			session=factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("delete from  Student where id=1").executeUpdate();
			session.getTransaction().commit();
			
			
		}
		finally{
			factory.close();
		}
	}
}
