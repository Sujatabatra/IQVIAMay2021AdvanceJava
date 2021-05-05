package com.sujata.persistence;

import java.util.ArrayList;

import com.sujata.bean.Employee;

public interface EmployeeDao {

	ArrayList<Employee> getAllEmployees();
	boolean insertEmployee(Employee employee);
	boolean deleteEmployee(int eId);
	boolean updateSalary(int eId,int salary);
	Employee searchById(int eId);
}
