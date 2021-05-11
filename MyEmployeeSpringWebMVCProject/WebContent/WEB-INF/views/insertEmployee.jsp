<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Insert Employee Details</h1>
	
	<spring:form action="./save">
	Enter Employee ID : <spring:input path="empId"/><br><br>
	Enter Employee First Name : <spring:input path="firstName"/><br><br>
	Enter Employee Last Name : <spring:input path="lastName"/><br><br>
	Enter User ID : <spring:input path="userId"/><br><br>
	Enter Employee Salary : <spring:input path="salary"/><br><br>
	<input type="submit" value="Save Employee">
	</spring:form>
<!--  
<form action="./save" method="post">
	Enter Employee ID : <input type="text" name="id"><br><br>
	Enter Employee First Name : <input type="text" name="fname"><br><br>
	Enter Employee Last Name : <input type="text" name="lname"><br><br>
	Enter User ID : <input type="text" name="uId"><br><br>
	Enter Employee Salary : <input type="text" name="salary"><br><br>
	<input type="submit" value="Save Employee">
</form>
-->
<br><br>
<a href="./">Go to Main Menu</a>
</body>
</html>