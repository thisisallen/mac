<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MAC | USER</title>
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
				<li><a href="userHome.jsp">Home</a></li>
				<li><a href="createMARUser.jsp">Create MAR</a></li>
			<li><a href="/mac/UsersController?action=searchAllMARs">View My Reports</a></li>
				<li><a href="/mac/UsersController?action=viewProfile">My
						Profile</a></li>
				<li><a href="/mac/UsersController?action=logout">Logout</a></li>
			</ul>
		</nav>
	</header>

	<div class="header_resize">
		<br>


	
					<table border="1" class="myTable">
						<tr>
							<td>Mar Number:</td>
							<td><c:out value="${REPORT.marNumber}" /></td>
						</tr>

						<tr>
							<td>Facility Name:</td>
							<td><c:out value="${REPORT.facilityName}" /></td>
						</tr>

						<tr>
							<td>Urgency:</td>
							<td><c:out value="${REPORT.urgency}" /></td>
						</tr>

						<tr>
							<td>Description:</td>
							<td><c:out value="${REPORT.description}" /></td>
						</tr>
						<tr>
							<td>Reported By:</td>
							<td><c:out value="${REPORT.reportedBy}" /></td>
						</tr>
						<tr>
							<td>Reported Date:</td>
							<td><c:out value="${REPORT.reportedDate}" /></td>
						</tr>
						<tr>
							<td>Assigned:</td>
							<td><c:out value="${REPORT.assigned}" /></td>
						</tr>
						<tr>
							<td>Requested:</td>
							<td><c:out value="${REPORT.requested}" /></td>
						</tr>


					</table>
</body>
</html>