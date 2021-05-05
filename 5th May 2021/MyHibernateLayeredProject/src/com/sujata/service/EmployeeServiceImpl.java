package com.sujata.service;

import java.util.ArrayList;

import com.sujata.bean.Employee;
import com.sujata.persistence.EmployeeDao;
import com.sujata.persistence.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao=new EmployeeDaoImpl();
	
	public ArrayList<Employee> getAllEmployeeRecords() {
		
		return employeeDao.getAllEmployees();
	}

	public boolean insertEmployeeRecord(Employee employee) {
		return employeeDao.insertEmployee(employee);
	}

	public boolean deleteEmployeeRecord(int eId) {
		
		return employeeDao.deleteEmployee(eId);
	}

	public boolean updateSalaryOfEmp(int eId, int salary) {
		
		return employeeDao.updateSalary(eId, salary);
	}

	public Employee searchEmpById(int eId) {
		return employeeDao.searchById(eId);
	}

}
