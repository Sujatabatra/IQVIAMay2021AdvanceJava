package com.sujata.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.sujata.bean.Student;
import com.sujata.bean.Trainer;





public class MyClient {

	public static void main(String[] args) {
		
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		
		//for entire application one session factory
		SessionFactory factory=meta.getSessionFactoryBuilder().build();

		//for every transaction one session
		Session session=factory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		Trainer t1=new Trainer("T001", "Trainer1");
		Trainer t2=new Trainer("T002", "Trainer2");
		
		Student s1=new Student("R001", "AAAAA");
		Student s2=new Student("R002", "BBBBB");
		Student s3=new Student("R003", "CCCCC");
		Student s4=new Student("R004", "DDDDD");
		Student s5=new Student("R005", "EEEEE");
		Student s6=new Student("R006", "FFFFF");
		
		s1.setTrainer(t1);
		s2.setTrainer(t1);
		s3.setTrainer(t1);
		
		s4.setTrainer(t2);
		s5.setTrainer(t2);
		s6.setTrainer(t2);
		
		
		t1.getStudents().add(s1);
		t1.getStudents().add(s2);
		t1.getStudents().add(s3);
		
		t2.getStudents().add(s4);
		t2.getStudents().add(s5);
		t2.getStudents().add(s6);
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		session.save(s5);
		session.save(s6);
		
		session.save(t1);
		session.save(t2);
		
		transaction.commit();
		
		session.close();
		
		System.out.println("Record Saved");
	}

}
