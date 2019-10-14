<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MAC | REPAIRMAN</title>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!--JQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- latest compiled Javascript-->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<header>
		<nav>
			<ul>
				<li><a href="repairmanHome.jsp">Home</a></li>
				<li><a
					href="/mac/RepairmanController?action=viewAssignedRepairs">View
						Assigned Repairs</a></li>
				<li><a
					href="/mac/RepairmanController?action=viewRequestedRepairs">View
						Requested Repairs</a></li>
				<li><a href="availableRepairs.jsps">View Available Repairs</a></li>
				<li><a href="/mac/UsersController?action=viewProfile">My
						Profile</a></li>
				<li><a href="/mac/UsersController?action=logout">Logout</a></li>
			</ul>
		</nav>
	</header>
	<form action="/mac/RepairmanController?action=editAssignedRepairs&id=${MARINFO.assignedID}" method="post">
	<table border="1">
		<tr>
			<td>MAR Number</td>
			<td><c:out value="${MARINFO.marNumber}" /></td>
		</tr>
		<tr>
			<td>Assigned Date</td>
			<td><c:out value="${MARINFO.assignedDate}" /></td>
		</tr>
		<tr>
			<td>Assigned Time</td>
			<td><c:out value="${MARINFO.assignedTime}" /></td>
		</tr>

		<tr>
			<td>Estimate Of Repairs</td>		
			<td>
				<select name="estimate">
					<option>${MARINFO.estimateOfRepairs}</option>
					<option value="30 minutes">30 minutes</option>
					<option value="1 hour">1 hour</option>
					<option value="2 hour">2 hour</option>
					</select></td>
		</tr>
		<tr>	
				<td><a href="/mac/RepairmanController?action=listSpecificRepair&id=${MARINFO.assignedID}" class="btn btn-info">CANCEL</a></td>
				<td><input type="submit" class="btn btn-danger" value="UPDATE"></td>
		</tr>
			
	</table>
	</form>
</body>
</html>