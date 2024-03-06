package com.gl.greatlearning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

public class UpdateFactory {
	public static void main(String[] args) {
		Session session = null;
		try {
			// This step will read hibernate.cfg.xml
			System.out.println("Before creating session factory object");
			// and prepare hibernate for use
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			System.out.println("fatory object created... before operating session");
			session = sessionFactory.openSession();
			System.out.println("updating records");
			Transaction transaction = session.beginTransaction();
			Employee emp = session.get(Employee.class, 101);
			emp.setSalary(110000);
			session.merge(emp);
			transaction.commit();
			
			System.out.println("Updated");
			System.out.println("Done");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			//Actually updation will happen at this step
			try {
				session.flush();
				session.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
