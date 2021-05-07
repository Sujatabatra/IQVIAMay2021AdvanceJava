<%@page import="com.sujata.bean.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	
<br><br>
	<table border="1">
		<tr>
			<th>Employee ID</th>
			<th>Employee First Name</th>
			<th>Employee Last Name</th>
			<th>User ID</th>
			<th>Salary</th>
		</tr>
		<c:forEach items="${employees}" var="empl">
			<tr>
				<td>${empl.empId}</td>
				<td>${empl.firstName }</td>
				<td>${empl.lastName }</td>
				<td>${empl.userId }</td>
				<td>${empl.salary}</td>
			</tr>
		</c:forEach>
	</table>


	<br>
	<br>
	<a href="./">Go To Main Page</a>
</body>
</html>