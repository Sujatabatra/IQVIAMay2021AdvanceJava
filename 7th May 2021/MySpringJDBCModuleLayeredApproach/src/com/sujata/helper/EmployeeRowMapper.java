package com.sujata.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sujata.bean.Employee;
/*
 * Row Mapper to map ResultSet with POJO Object
 */
public class EmployeeRowMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		int eid=rs.getInt("id");
		String fname=rs.getString("first_name");
		String lname=rs.getString("last_name");
		String userId=rs.getString("userid");
		int sal=rs.getInt("Salary");
		
		Employee emp=new Employee(eid, fname, lname, userId, sal);
		
		return emp;
	}

}
