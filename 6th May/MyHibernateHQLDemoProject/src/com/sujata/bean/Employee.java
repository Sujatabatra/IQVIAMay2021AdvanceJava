package com.sujata.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//we are mapping this pojo object with table
@Entity
@Table(name="EmpSujata")
@NamedQueries({
		@NamedQuery(name="getAllEmployees",query="from Employee"),
		@NamedQuery(name="updateSalary",query="Update Employee set salary=:sal where name=:name")
		})
public class Employee {

	//this column , i.e eId will b the primary key
	@Id
	@Column(name="empId")
	private int eId;
	
	@Column(name="empName")
	private String name;
	
	@Column(name="deptt")
	private String department;
	
	@Column(name="desig")
	private String designation;
	
	private int salary;

	public Employee() {

	}

	public Employee(int eId, String name, String department, String designation, int salary) {
		super();
		this.eId = eId;
		this.name = name;
		this.department = department;
		this.designation = designation;
		this.salary = salary;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
