package com.sujata.persistence;

import java.util.ArrayList;

import com.sujata.bean.Employee;

public interface EmployeeDao {

	ArrayList<Employee> getEmployees();
	boolean insertRecord(Employee employee);
	boolean deleteRecord(int empId);
	
	Employee searchById(int eid);
	
	
}
