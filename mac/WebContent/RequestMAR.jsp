<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MAC | REPAIRMAN</title>
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
				<li><a href="/mac/RepairmanController?action=searchAllMARs">View Available Repairs</a></li>
				<li><a href="/mac/UsersController?action=viewProfile">My
						Profile</a></li>
				<li><a href="/mac/UsersController?action=logout">Logout</a></li>
			</ul>
		</nav>
	</header>
	<form action="/mac/RepairmanController?action=request1&id=${REPORT.marNumber}" method="post">
		<table border="1" class="myTable">

			<tr>
				<td>MAR number</td>
				<td><c:out value="${REPORT.marNumber}" /></td>
			</tr>

			<tr>
				<td>Requested Date</td>
				<td><input type="date" name="date"/></td>
			</tr>
			
			<tr>
				<td>Requested Time</td>
				<td><input type="time" name="time"/></td>
			</tr>

			<tr>
				<td>Estimated Time of Repair</td>
				<td>
					<select name="estimate">
						<option value="30 minutes">30 minutes</option>
						<option value="1 hour">1 hour</option>
						<option value="2 hours">2 hours</option>
					</select></td>
			</tr>


			<tr>
				<td><input type="submit" class="btn btn-danger" value="Request MAR">
				
			</tr>

		</table>
	</form>

</body>
</html>