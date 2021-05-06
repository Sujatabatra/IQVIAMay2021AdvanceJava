package conm.sujata.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

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
		
		Query query=session.createQuery("select eId,name,salary from Employee");
		List<Object[]> myList=query.getResultList();
		
		for(Object[] row:myList){
			for(Object ele:row)
				System.out.print(ele+"  ");
			System.out.println();
		}
		
		System.out.println("=====================");
		
		Query query1=session.createQuery("select eId,name,salary from Employee where department=:dep");
		query1.setParameter("dep", "Sales");
		List<Object[]> myList1=query1.getResultList();
		
		for(Object[] row1:myList1){
			for(Object ele1:row1)
				System.out.print(ele1+"  ");
			System.out.println();
		}
		
		System.out.println("=====================");
		
		System.out.println("Demonstrating DML using HQL");
		Query query2=session.createQuery("delete from  Employee where designation=:des");
		query2.setParameter("des", "Executive");
		
		int rows=query2.executeUpdate();
		if(rows>0)
			System.out.println("Record Deleted ");
		else
			System.out.println("Record not Deleted");
		
//		NativeQuery query3=session.createSQLQuery("delete from empSujata where desig=?");
		
		System.out.println("Using named queries");
		
		Query query4=session.getNamedQuery("updateSalary");
		query4.setParameter("sal", 75000);
		query4.setParameter("name", "Ashish");
		
		int rowCount=query4.executeUpdate();
		if(rowCount>0)
			System.out.println("Update Successful!");
		else
			System.out.println("Update Failed!");
		transaction.commit();
		
		session.close();
		
		
	}

}
