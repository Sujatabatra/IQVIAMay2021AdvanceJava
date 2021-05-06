package conm.sujata.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.sujata.bean.Employee;

public class MyClient {

	public static void main(String[] args) {
		
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		
		//for entire application one session factory
		SessionFactory factory=meta.getSessionFactoryBuilder().build();

		//for every transaction one session
		Session session=factory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		Employee employee1=new Employee(101, "Ashish", "IT", "Associate", 56000);
		Employee employee2=new Employee(102, "Bharti", "Sales", "Executive", 36000);
		Employee employee3=new Employee(103, "Chandan", "Purchase", "Associate", 76000);
		Employee employee4=new Employee(104, "Diksha", "IT", "Manager", 196000);
		Employee employee5=new Employee(105, "Esha", "Sales", "Sr. Associate", 96000);
		Employee employee6=new Employee(106, "Falak", "IT", "Associate", 64000);
		
		session.save(employee1);
		session.save(employee2);
		session.save(employee3);
		session.save(employee4);
		session.save(employee5);
		session.save(employee6);
		
		transaction.commit();
		
		session.close();
		
		System.out.println("Record Saved");
	}

}
