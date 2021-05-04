package com.sujata.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sujata.model.service.EmployeeService;
import com.sujata.model.service.EmployeeServiceImpl;

public class DeleteEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		EmployeeService employeeService=new EmployeeServiceImpl();
		String message=null;
		if(employeeService.deleteEmployee(Integer.parseInt(request.getParameter("empId"))))
			message="Employee deleted Succesfully";
		else
			message="Employee Deletion Failed";
		
		
		session.setAttribute("msg", message);
		
		response.sendRedirect("./output.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
