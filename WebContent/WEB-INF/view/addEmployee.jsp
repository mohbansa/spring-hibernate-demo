<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
</head>
<body>
	
	<form:form action="" method="POST">
		Employee Name : <br/> <form:input path="name"/> <br/>
		Email : <br/> <form:input path="email"/> <br/>
		Department : <br/> <form:input path="dept"/> <br/>
		Base Location : <br/> <form:input path="baseLocation"/> <br/>
		<input type="submit" value="Add" />
	</form:form>
	
</body>
</html>