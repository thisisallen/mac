<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<header> <nav>
<ul>
	<li><a href="facilityManagerHome.jsp">Home</a></li>
	<li><a href="/mac/FacilityManagerController?action=listFacilities">View
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
</nav> </header>
<div class="header_resize">
	<h4>
		<a href="/mac/index1.jsp">View Facility</a>
	</h4>
	<br>
</head>
<body>
	
				<table border="1" class="myTable">
					<tr>
						<td>Facility Name:</td>
						<td><c:out value="${USERS.facilityName}" /></td>
					</tr>

					<tr>
						<td>Facility Type:</td>
						<td><c:out value="${USERS.facilityType}" /></td>
					</tr>
					
					<tr>
						<td>Time Interval:</td>
						<td><c:out value="${USERS.timeInterval}" /></td>
					</tr>

					<tr>
						<td>Duration:</td>
						<td><c:out value="${USERS.duration}" /></td>
					</tr>

					<tr>
						<td>Venue:</td>
						<td><c:out value="${USERS.venue}" /></td>
					</tr>

<tr><td><a
				href="/mac/FacilityManagerController?action=listFacilities"
				class="btn btn-info">BACK</a></td>
			<td>	 <a href="/mac/FacilityManagerController?action=listSpecificFacility1&id=${USERS.facilityName}" class="btn btn-danger">EDIT</a></td> 
</body>
</html>