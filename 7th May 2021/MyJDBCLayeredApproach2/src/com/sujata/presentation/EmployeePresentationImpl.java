package com.sujata.presentation;

import java.util.ArrayList;
import java.util.Scanner;

import com.sujata.bean.Employee;
import com.sujata.service.EmployeeService;
import com.sujata.service.EmployeeServiceImpl;

public class EmployeePresentationImpl implements EmployeePresentation {

//	private EmployeeService employeeService=new EmployeeServiceImpl();
	
	private EmployeeService employeeService;
	
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void showMenu() {
		System.out.println("1. Show All Employees");
		System.out.println("2. Insert Employee ");
		System.out.println("3. Delete Employee");
		System.out.println("4. Search Employee By ID ");
		System.out.println("5. Exit");

	}

	public void performMenu(int choice) {
		Scanner sc=new Scanner(System.in);
		switch(choice){
		case 1:
			ArrayList<Employee> employees=employeeService.getAllEmployees();
			for(Employee employee:employees){
				System.out.println(employee);
			}
		break;
		case 2:
			System.out.println("Enter employee id : ");
			int id=sc.nextInt();
			System.out.println("Enter employee first name : ");
			String fn=sc.next();
			System.out.println("Enter employee last name : ");
			String ln=sc.next();
			System.out.println("Enter user id : ");
			String uid=sc.next();
			System.out.println("Enter salary : ");
			int sal=sc.nextInt();
			
			Employee emp=new Employee(id, fn, ln, uid, sal);
			if(employeeService.insertEmployee(emp))
				System.out.println("Employee inserted successfully");
			else
				System.out.println("Employee insertion failed");
			break;
		case 3:
			System.out.println("Enter employee id whoes record you want to delete ");
			int eId=sc.nextInt();
			if(employeeService.deleteEmployee(eId))
				System.out.println("Employee Deleted");
			else
				System.out.println("Employee not Deleted");
			break;
		case 4:
			System.out.println("Enter employee id whoes record you want to search : ");
			int empId=sc.nextInt();
			Employee empl=employeeService.searchEmployeeById(empId);
			if(empl!=null)
				System.out.println(empl);
			else
				System.out.println("Employee not found with employee id "+empId);
			break;
		case 5:
			System.out.println("Thanks for using Employee Management System! Have a Nice Day!");
			System.exit(0);
			
		}

	}

}
