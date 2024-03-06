package com.gl.greatlearning;

import java.lang.module.Configuration;
import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RetrieveEmpData {

	public static void main(String[] args) {
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		//Employee emp=session.get(Employee.class, 101);
		Query query = session.createQuery("from Employee");
		List<Employee> listr = query.list();
		//Employee emp = null;
		System.out.println("Id: "+emp.getEmpId());
		System.out.println("Name: "+ emp.getEmpName());
		System.out.println("Salary: "+emp.getSalary());
		
		sessionFactory.close();
}
}
