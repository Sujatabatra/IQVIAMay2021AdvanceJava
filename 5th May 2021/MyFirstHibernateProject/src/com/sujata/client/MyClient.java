package com.sujata.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.sujata.demo.Employee;

public class MyClient {

	public static void main(String[] args) {
		
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		
		//for entire application one session factory
		SessionFactory factory=meta.getSessionFactoryBuilder().build();

		//for every transaction one session
		Session session=factory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		Employee employee=new Employee(101, "Ashish", "IT", "Associate", 56000);
		
		session.save(employee);
		
		transaction.commit();
		
		session.close();
		
		System.out.println("Record Saved");
	}

}
