package com.sujata.persistence;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.sujata.bean.Employee;
import com.sujata.util.MySessionFactoryClass;

public class EmployeeDaoImpl implements EmployeeDao {

	public ArrayList<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insertEmployee(Employee employee) {
		MySessionFactoryClass sessionFactory=new MySessionFactoryClass();

		SessionFactory factory=sessionFactory.getSessionFactory();
		
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		session.save(employee);

		transaction.commit();

		session.close();

		return true;
	}

	public boolean deleteEmployee(int eId) {
		MySessionFactoryClass sessionFactory=new MySessionFactoryClass();

		SessionFactory factory=sessionFactory.getSessionFactory();
		
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Employee employee=session.get(Employee.class, eId);
		session.delete(employee);
		
		
		transaction.commit();

		session.close();

		return true;
	}

	public boolean updateSalary(int eId, int salary) {
		MySessionFactoryClass sessionFactory=new MySessionFactoryClass();

		SessionFactory factory=sessionFactory.getSessionFactory();
		
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Employee employee=session.get(Employee.class, eId);
		boolean status=false;
		if(employee!=null){
			employee.setSalary(salary);
			
			status=true;
		}

		transaction.commit();

		session.close();

		return status;
	}

	public Employee searchById(int eId) {
		MySessionFactoryClass sessionFactory=new MySessionFactoryClass();

		SessionFactory factory=sessionFactory.getSessionFactory();
		
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Employee employee=session.get(Employee.class, eId);

		transaction.commit();

		session.close();

		return employee;
	}

}
