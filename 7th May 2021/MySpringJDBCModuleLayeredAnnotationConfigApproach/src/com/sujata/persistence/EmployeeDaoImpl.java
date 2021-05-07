package com.sujata.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.sujata.bean.Employee;
import com.sujata.helper.EmployeeRowMapper;

@Component("empDao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public ArrayList<Employee> getEmployees() {
		List<Employee> employees=jdbcTemplate.query("select * from my_employee", new EmployeeRowMapper());
		return (ArrayList<Employee>)employees;
	}

	public boolean insertRecord(Employee employee) {
		int rows=jdbcTemplate.update("insert into my_employee values(?,?,?,?,?)", employee.getEmpId(),employee.getLastName(),employee.getFirstName(),employee.getUserId(),employee.getSalary());
		if(rows>0)
			return true;
		return false;
	}

	public boolean deleteRecord(int empId) {
		int rows=jdbcTemplate.update("delete from my_employee where id=?", empId);
		if(rows>0)
			return true;
		return false;
	}

	public Employee searchById(int eid) {
		Employee emp=jdbcTemplate.queryForObject("select * from my_employee where id="+eid, new EmployeeRowMapper());
		return emp;
	}

}
