<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Employees</title>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<h3>Hello from Nikhil</h3>
	
	<p> ${list} </p>
	
	<div class="container">
		<h3>All Employees</h3>
		<table class="table">
			<tr> <th>EmpId</th> <th>Name</th> <th>Email</th> <th>Base Location</th></tr>
			<jstl:forEach var="emp" items="${list}">
				<tr>
					<td>
						<jstl:out value="${emp.name}"></jstl:out>
					</td>
					<td>
						<jstl:out value="${emp.email}"></jstl:out>
					</td>
					<td>
						<jstl:out value="${emp.dept}"></jstl:out>
					</td>
					<td>
						<jstl:out value="${emp.baseLocation}"></jstl:out>
					</td>
					<td>
						<button onclick="deleteEmployee(${emp.id})">Delete</button>	
					</td>
				</tr>
			</jstl:forEach>
		</table>
		
		<div id="pages"></div>
		<select id="total">
			<option value=10>10</option>
			<option value=10>20</option>
			<option value=10>30</option>
		</select>
		
		<script type="text/javascript">
			
		console.log("trying to delete : ");


		var total = 0;
		for(ab = 5 ; ab <= 10 ; ab++){
			console.log(ab, "\n");
			total++;
		}
		console.log(total);

		var total = 0;
		for(ab = 5 ; ab <= 10 ; ab++){
			console.log(ab, "\n");
			if(ab == 6){
				break;
			}
			total++;
		}
		console.log(total);
		console.log("End \n Nikhil");

			function deleteEmployee(empId){
				console.log("trying to delete : ", empId);
			}
		
			/* function getNumberOfPageButton(){
				if(){
					
				}
			} */
		
			function getPageButtonObj(){
				
			}	
		
		
		</script>
		
	</div>
	
	
	
</body>
</html>