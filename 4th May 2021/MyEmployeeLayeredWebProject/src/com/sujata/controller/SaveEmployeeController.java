package com.sujata.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sujata.bean.Employee;
import com.sujata.model.service.EmployeeService;
import com.sujata.model.service.EmployeeServiceImpl;

public class SaveEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//to pick the session: if checks if the session already exist pick it otherwise create the new session
		HttpSession session=request.getSession();
		
		String eId=request.getParameter("id");
		String fn=request.getParameter("fname");
		String ln=request.getParameter("lname");
		String uid=request.getParameter("uId");
		String sal=request.getParameter("salary");
		
		Employee employee=new Employee(Integer.parseInt(eId), fn, ln, uid, Integer.parseInt(sal));
		
		EmployeeService employeeService=new EmployeeServiceImpl();
		String message=null;
		if(employeeService.insertEmployee(employee))
			message="Employee Saved Successfully";
		else
			message="Employee Insertion Failed";
		
		
		session.setAttribute("msg", message);
		response.sendRedirect("./output.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
