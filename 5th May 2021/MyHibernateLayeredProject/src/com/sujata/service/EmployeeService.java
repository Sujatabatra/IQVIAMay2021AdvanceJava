package com.sujata.service;

import java.util.ArrayList;

import com.sujata.bean.Employee;

public interface EmployeeService {

	ArrayList<Employee> getAllEmployeeRecords();
	boolean insertEmployeeRecord(Employee employee);
	boolean deleteEmployeeRecord(int eId);
	boolean updateSalaryOfEmp(int eId,int salary);
	Employee searchEmpById(int eId);
}
