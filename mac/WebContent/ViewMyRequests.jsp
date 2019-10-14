<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<table border="1">
		<tr>
			<th>MAR Number</th>
			<th>Facility Name</th>
			<th>Requested Date</th>
			<th>Requested Time</th>
			<th>Estimate Of Repairs</th>
			
		</tr>

		<c:forEach items="${REQUESTED_MARS}" var="item" varStatus="status">
			<tr>
				<td><c:out value="${item.marNumber}" /></td>
				<td><c:out value="${item.facilityName}" /></td>
				<td><c:out value="${item.assignedDate}" /></td>
				<td><c:out value="${item.assignedTime}" /></td>
				<td><c:out value="${item. estimateOfRepairs}" /></td>
				
		</c:forEach>
	</table>
</body>
</html>