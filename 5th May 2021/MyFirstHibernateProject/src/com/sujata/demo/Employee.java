package com.sujata.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

//we are mapping this pojo object with table
@Entity
public class Employee {

	//this column , i.e eId will b the primary key
	@Id
	private int eId;
	private String name;
	private String department;
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
