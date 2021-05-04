package com.sujata.model.service;

import java.util.ArrayList;

import com.sujata.bean.Employee;
import com.sujata.model.persistence.EmployeeDao;
import com.sujata.model.persistence.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao=new EmployeeDaoImpl();
	
	public ArrayList<Employee> getAllEmployees() {
		
		return employeeDao.getEmployees();
	}

	public boolean insertEmployee(Employee employee) {
		return employeeDao.insertRecord(employee);
	}

	public boolean deleteEmployee(int empId) {
		return employeeDao.deleteRecord(empId);
	}

	public Employee searchEmployeeById(int eid) {
		return employeeDao.searchById(eid);
	}

}
