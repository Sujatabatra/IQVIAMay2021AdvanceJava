package com.sujata.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sujata.bean.MyNumbers;
import com.sujata.model.service.MyCalculatorService;
import com.sujata.model.service.MyCalculatorServiceImpl;


public class MyCalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//picked data from request
		String no1=request.getParameter("no1");
		String no2=request.getParameter("no2");
		String op=request.getParameter("operation");
		
		MyNumbers numbers=new MyNumbers(Integer.parseInt(no1), Integer.parseInt(no2));
		
		MyCalculatorService calcService=new MyCalculatorServiceImpl();
		int result=0;
		String message="";
		//calling the service methods
		switch(op){
		case "+":
			message="Sum";
			result=calcService.sum(numbers);
			break;
		case "-":
			message="Difference";
			result=calcService.difference(numbers);
			break;
		case "*":
			message="Product";
			result=calcService.multiply(numbers);
			break;
		case "/":
			message="Divide";
			result=calcService.divide(numbers);
			break;
		}
		
		ServletContext application=request.getServletContext();
		
		application.setAttribute("result", result);
		application.setAttribute("message", message);
		
		
		response.sendRedirect("./result.jsp");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
