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
	<c:if test="${not empty employee }">
		<table border="1">
			<tr>
				<th>Employee ID</th>
				<th>Employee First Name</th>
				<th>Employee Last Name</th>
				<th>User ID</th>
				<th>Salary</th>
			</tr>

			<tr>
				<td>${employee.empId}</td>
				<td>${employee.firstName }</td>
				<td>${employee.lastName }</td>
				<td>${employee.userId }</td>
				<td>${employee.salary}</td>
			</tr>

		</table>
	</c:if>
	
	<c:if test="${empty employee }">
		<%="Employee does not exist" %>
	</c:if>
	
	<br><br>
	<a href="./">Go Back to Main Page</a>
</body>
</html>