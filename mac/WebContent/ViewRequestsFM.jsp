<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MAC | FACILITY MANAGER</title>
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
				<li><a href="facilityManagerHome.jsp">Home</a></li>
				<li><a
					href="/mac/FacilityManagerController?action=listFacilities">View
						Facilities</a></li>
				<li><a
					href="/mac/FacilityManagerController?action=searchAllMARs">All
						MARs</a></li>
				<li><a
					href="/mac/FacilityManagerController?action=searchAssignedMARs">Assigned
						MARs</a></li>
				<li><a href="/mac/UsersController?action=viewProfile">My
						Profile</a></li>
				<li><a href="/mac/UsersController?action=logout">Logout</a></li>
			</ul>
		</nav>
	</header>
	<div class="header_resize">
		<br>


<table border="1">
		<tr>
			<th>MAR Number</th>
			<th>Requested By</th>
			<th>Requested Date</th>
			<th>Requested Time</th>
			<th>Estimate Of Repairs</th>
			<th>Assign</th>
		</tr>
		<c:forEach items="${ALL_REQUESTS}" var="item">
			<tr>
				<td>${item.marNumber}</td>
				<td>${item.requestedBy}</td>
				<td>${item.requestedDate }</td>
				<td>${item.requestedTime }</td>
				<td>${item.estimateOfRepairs }</td>
				<td><a href="/mac/FacilityManagerController?action=assignRepairman&id1=${item.marNumber}&id2=${item.requestedBy}&id3=${item.requestedDate}&id4=${item.requestedTime }&id5=${item.estimateOfRepairs }" class="btn btn-info">Assign</a></td>
			</tr>
		</c:forEach>
<tr><td>
					<a href="/mac/FacilityManagerController?action=searchAllMARs"
					class="btn btn-info">BACK</a></td>
					
						</table>
</body>
</html>