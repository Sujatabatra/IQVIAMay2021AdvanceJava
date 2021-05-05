package com.sujata.presentation;

import java.util.ArrayList;
import java.util.Scanner;

import com.sujata.bean.Employee;
import com.sujata.service.EmployeeService;
import com.sujata.service.EmployeeServiceImpl;

public class EmployeePresentationImpl implements EmployeePresentation {

	private EmployeeService employeeService=new EmployeeServiceImpl();
	
	public void showMenu() {
		System.out.println("1. Insert Employee");
		System.out.println("2. Search By ID ");
		System.out.println("3. Delete Employee By ID");
		System.out.println("4. Update Employee Salary");
		System.out.println("5. List All Employees ");
		System.out.println("6. Exit");

	}

	public void performMenu(int choice) {
		Scanner sc=new Scanner(System.in);
		switch(choice){
		case 1:
			System.out.println("Enter Employee Id : ");
			int id=sc.nextInt();
			System.out.println("Enter Employee Name : ");
			String name=sc.next();
			System.out.println("Enter Employee Designation : ");
			String desig=sc.next();
			System.out.println("Enter Employee Department : ");
			String dept=sc.next();
			System.out.println("Enter Employee Salary : ");
			int sal=sc.nextInt();
			Employee emp=new Employee(id, name, dept, desig, sal);
			if(employeeService.insertEmployeeRecord(emp))
				System.out.println("Employee Inserted Successfully!");
			else
				System.out.println("Employee Record Insertion Failed!");
			break;
		case 2:
			System.out.println("Enter employee ID to be serached for : ");
			int eid=sc.nextInt();
			Employee employee=employeeService.searchEmpById(eid);
			if(employee!=null)
				System.out.println(employee);
			else
				System.out.println("Employee with id "+eid+" does not exist");
			break;
		case 3:
			System.out.println("Enter employee ID to be deleted for :");
			int empId=sc.nextInt();
			if(employeeService.deleteEmployeeRecord(empId))
				System.out.println("Record Deleted Successfully!");
			else
				System.out.println("Record Not deleted!");
			break;
		case 4:
			System.out.println("Enter employee Id whoes salary you want to update : ");
			int employeeId=sc.nextInt();
			System.out.println("Enter new Salary : ");
			int salary=sc.nextInt();
			if(employeeService.updateSalaryOfEmp(employeeId, salary))
				System.out.println("Salary updated Successfully!");
			else
				System.out.println("Salary updation Failed!");
			break;
		case 5:
			ArrayList<Employee> employees=employeeService.getAllEmployeeRecords();
			for(Employee e:employees){
				System.out.println(e);
			}
			break;
		case 6:
			System.out.println("Thanks for using employee management system, have a great day!");
			System.exit(0);
		}

	}

}
