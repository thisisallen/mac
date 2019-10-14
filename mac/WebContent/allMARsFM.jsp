<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

	<form
		action="/mac/FacilityManagerController?action=searchSpecificMars"
		method="post">
		<p>Assigned MAR: </p>
		<select name="assigned">
			<option value="ALL">ALL</option>
			<option value="YES">YES</option>
			<option value="NO">NO</option>
		</select>
		<p>Requested MAR: </p>
		<select name="requested">
			<option value="ALL">ALL</option>
			<option value="YES">YES</option>
			<option value="NO">NO</option>
		</select>
		<input
			type="submit" name="submit" value="SEARCH">
	</form>

	<table border="1">
		<tr>
			<th>MAR Number</th>
			<th>Facility Name</th>
			<th>Urgency</th>
			<th>Requested</th>
			<th>Assigned</th>
		</tr>
		<c:forEach items="${ALL_REPORTS}" var="item">
			<tr>
				<td>${item.marNumber}</td>
				<td>${item.facilityName }</td>
				<td>${item.urgency }</td>
				<td>${item.requested}</td>
				<td>${item.assigned}</td>
				<td><a
					href="/mac/MARsController?action=listSpecificMarReport&id=${item.marNumber}"
					class="btn btn-info">View</a></td>
				<td><a
					href="/mac/MARsController?action=listRequests&id=${item.marNumber}"
					class="btn btn-info">View Requests</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>