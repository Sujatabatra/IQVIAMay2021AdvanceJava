package com.sujata.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.sujata.bean.Husband;
import com.sujata.bean.Wife;



public class MyClient {

	public static void main(String[] args) {
		
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		
		//for entire application one session factory
		SessionFactory factory=meta.getSessionFactoryBuilder().build();

		//for every transaction one session
		Session session=factory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		Wife w1=new Wife("w001", "wife1");
		Wife w2=new Wife("w002", "wife2");
		Wife w3=new Wife("w003", "wife3");
		Wife w4=new Wife("w004", "wife4");
		
		
		Husband h1=new Husband("h001", "husband1");
		Husband h2=new Husband("h002", "husband2");
		Husband h3=new Husband("h003", "husband3");
		Husband h4=new Husband("h004", "husband4");
		
		w1.setHusband(h4);
		w2.setHusband(h3);
		w3.setHusband(h2);
		w4.setHusband(h1);
		
		h1.setWife(w4);
		h2.setWife(w3);
		h3.setWife(w2);
		h4.setWife(w1);
		
		session.save(w1);
		session.save(w2);
		session.save(w3);
		session.save(w4);
		
		session.save(h1);
		session.save(h2);
		session.save(h3);
		session.save(h4);
		
		transaction.commit();
		
		session.close();
		
		System.out.println("Record Saved");
	}

}
