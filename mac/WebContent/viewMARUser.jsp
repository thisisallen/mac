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
				<li><a href="/mac/MARsController?action=searchAllUserMars">View
						My Reports</a></li>
				<li><a href="/mac/UsersController?action=viewProfile">My
						Profile</a></li>
				<li><a href="/mac/UsersController?action=logout">Logout</a></li>
			</ul>
		</nav>
	</header>

	<table>
		<tr>
			<td>
				<table border="1" class="myTable">
					<tr>
						<th>Mar Number:</th>
						<th>Facility Name:</th>
						<th>Urgency:</th>
						<th>Description:</th>
						<th>Reported By:</th>
						<th>Reported Date:</th>
					</tr>


					<c:forEach items="${userMARs}" var="item" varStatus="status">
						<tr>
							<td><c:out value="${item.marNumber}" /></td>
							<td><c:out value="${item.facilityName}" /></td>
							<td><c:out value="${item. urgency}" /></td>
							<td><c:out value="${item. description}" /></td>
							<td><c:out value="${item. reportedBy}" /></td>
							<td><c:out value="${item. reportedDate}" /></td>
							<td><a href="/mac/MARsController?action=listSpecificMAR&id=${item.marNumber}">View</a></td>
						</tr>
					</c:forEach>
				</table>
</body>
</html>