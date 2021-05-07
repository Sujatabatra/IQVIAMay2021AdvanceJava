package com.sujata.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sujata.bean.Employee;
import com.sujata.persistence.EmployeeDao;
import com.sujata.persistence.EmployeeDaoImpl;

@Component("empService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
	super();
	this.employeeDao = employeeDao;
}

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
