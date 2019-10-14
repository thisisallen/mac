<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MAC | REPAIRMAN</title>
<meta charset="ISO-8859-1">
<title>MAC | MAIN</title>
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
	<table border="1">
		<tr>
			<td>MAR Number</td>
			<td><c:out value="${REPORT.marNumber}" /></td>
		</tr>
		
		<tr>
			<td>Facility Name</td>
			<td><c:out value="${REPORT.facilityName}" /></td>
		</tr>
		
		<tr>
			<td>Urgency</td>
			<td><c:out value="${REPORT.urgency}" /></td>
		</tr>
		
		<tr>
			<td>Description</td>
			<td><c:out value="${REPORT.description}" /></td>
		</tr>
		
		<tr>
			<td>Assigned Date</td>
			<td><c:out value="${REPORT.assignedDate}" /></td>
		</tr>
		
		<tr>
			<td>Assigned Time</td>
			<td><c:out value="${REPORT.assignedTime}" /></td>
		</tr>

		<tr>
			<td>Estimate Of Repairs</td>
			<td><c:out value="${REPORT.estimateOfRepairs}" /></td>
		</tr>
		<tr>
			<td><a
				href="/mac/RepairmanController?action=viewAssignedRepairs" class="btn btn-info">BACK</a></td>
				<td><a
				href="/mac/RepairmanController?action=displayMARForUpdate&id=${REPORT.assignedID}" class="btn btn-info">EDIT</a></td>
		</tr>
	</table>
</body>
</html>