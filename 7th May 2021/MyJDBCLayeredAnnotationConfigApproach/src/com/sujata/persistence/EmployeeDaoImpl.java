package com.sujata.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.sujata.bean.Employee;

@Component("empDao")
public class EmployeeDaoImpl implements EmployeeDao {

	
	public ArrayList<Employee> getEmployees() {
		Connection connection=null;
		ArrayList<Employee> empList=new ArrayList<Employee>();
		try {
			//1. Connect
			//1.1 Register Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//1.2 Connect to Database
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			
			//2. statement : DQL (Data Query Language)
			PreparedStatement preparedStatement=connection.prepareStatement("select * from my_employee");
			ResultSet rs=preparedStatement.executeQuery();
			
			
			//3. Process the result
			while(rs.next()){
				
				int eid=rs.getInt("id");
				String fname=rs.getString("first_name");
				String lname=rs.getString("last_name");
				String userId=rs.getString("userid");
				int sal=rs.getInt("Salary");
				
				
				Employee emp=new Employee(eid, fname, lname, userId, sal);
				
				empList.add(emp);
				
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			//4.Close
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return empList;
	}

	public boolean insertRecord(Employee employee) {
		Connection connection=null;
		ArrayList<Employee> empList=new ArrayList<Employee>();
		try {
			//1. Connect
			//1.1 Register Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//1.2 Connect to Database
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			
			//2. statement : DML
			PreparedStatement preparedStatement=connection.prepareStatement("insert into my_employee values(?,?,?,?,?)");
			
			preparedStatement.setInt(1, employee.getEmpId());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setString(3, employee.getFirstName());
			preparedStatement.setString(4, employee.getUserId());
			preparedStatement.setInt(5, employee.getSalary());
			
			
			int rows=preparedStatement.executeUpdate();
			
			
			//3. Process the result
			if(rows>0)
				return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			//4.Close
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		return false;
	}

	public boolean deleteRecord(int empId) {
		Connection connection=null;
		ArrayList<Employee> empList=new ArrayList<Employee>();
		try {
			//1. Connect
			//1.1 Register Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//1.2 Connect to Database
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			
			//2. statement : DML
			PreparedStatement preparedStatement=connection.prepareStatement("delete from my_employee where id=?");
			
			preparedStatement.setInt(1, empId);
			
			int rows=preparedStatement.executeUpdate();
			
			//3. Process the result
			if(rows>0)
				return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			//4.Close
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		return false;
	}

	public Employee searchById(int eid) {
		Connection connection=null;
		Employee emp=null;
		try {
			//1. Connect
			//1.1 Register Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//1.2 Connect to Database
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			
			//2. statement : DQL (Data Query Language)
			PreparedStatement preparedStatement=connection.prepareStatement("select * from my_employee where id=?");
			preparedStatement.setInt(1, eid);
			
			ResultSet rs=preparedStatement.executeQuery();
			
			//3. Process the result
			if(rs.next()){
				
				int id=rs.getInt("id");
				String fname=rs.getString("first_name");
				String lname=rs.getString("last_name");
				String userId=rs.getString("userid");
				int sal=rs.getInt("Salary");
				
				emp=new Employee(id, fname, lname, userId, sal);
				
				
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			//4.Close
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return emp;
	}

}
