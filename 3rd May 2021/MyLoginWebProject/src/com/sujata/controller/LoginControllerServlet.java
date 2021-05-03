package com.sujata.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sujata.bean.User;
import com.sujata.service.LoginService;
import com.sujata.service.LoginServiceImpl;


public class LoginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String userName=request.getParameter("uname");
		String password=request.getParameter("pwd");
		
		User user=new User(userName, password);
	
		LoginService loginService=new LoginServiceImpl();
		pw.println("<HTML>");
		pw.println("<HEAD>");
		pw.println("<TITLE>Login Page</TITLE>");
		pw.println("</HEAD>");
		pw.println("<BODY>");
		if(loginService.loginCheck(user)){
			pw.println("<H1>Login Successful!</H1>");
		}
		else{
			pw.println("<H1>Login Failed!</H1>");
		}
		pw.println("</BODY>");
		pw.println("</HTML>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
