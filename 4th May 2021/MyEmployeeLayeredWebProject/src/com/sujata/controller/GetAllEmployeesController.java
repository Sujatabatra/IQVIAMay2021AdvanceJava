package com.sujata.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sujata.bean.Employee;
import com.sujata.model.service.EmployeeService;
import com.sujata.model.service.EmployeeServiceImpl;

public class GetAllEmployeesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		EmployeeService employeeService=new EmployeeServiceImpl();
		ArrayList<Employee> empList=employeeService.getAllEmployees();
		
		session.setAttribute("employees", empList);
		
		response.sendRedirect("./showAllEmployees.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
