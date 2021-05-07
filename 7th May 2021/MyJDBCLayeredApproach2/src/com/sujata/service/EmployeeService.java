package com.sujata.service;

import java.util.ArrayList;

import com.sujata.bean.Employee;

public interface EmployeeService {

	ArrayList<Employee> getAllEmployees();
	boolean insertEmployee(Employee employee);
	boolean deleteEmployee(int empId);
	Employee searchEmployeeById(int eid);
}
