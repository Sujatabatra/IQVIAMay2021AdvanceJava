package com.sujata.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		pw.println("<HTML>");
		pw.println("<HEAD>");
		pw.println("<TITLE>welcome to our first servlet</TITLE>");
		pw.println("</HEAD>");
		pw.println("<BODY>");
		pw.println("<H1>Welcome to the world of servlet!</H1>");
		pw.println("</BODY>");
		pw.println("</HTML>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
