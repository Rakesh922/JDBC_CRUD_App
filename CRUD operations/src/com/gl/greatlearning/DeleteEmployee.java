package com.gl.greatlearning;

import java.lang.module.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class DeleteEmployee {
	public static void main(String[] args) {
		Session session = null;
		try {
			// This step will read hibernate.cfg.xml
			System.out.println("Before creating session factory object");
			// and prepare hibernate for use
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			System.out.println("fatory object created... before operating session");
			session = sessionFactory.openSession();
			System.out.println("Deleting records");
			Transaction transaction = session.beginTransaction();
			Employee emp = session.get(Employee.class, 101);
			session.delete(emp);
			transaction.commit();
			
			System.err.println("Row Delete....!");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			
		}

}
