<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
				<li><a href="availableRepairs.jsps">View Available Repairs</a></li>
				<li><a href="/mac/UsersController?action=viewProfile">My
						Profile</a></li>
				<li><a href="/mac/UsersController?action=logout">Logout</a></li>
			</ul>
		</nav>
	</header>
	
				<table border="1" class="myTable">
					<tr>
						<td>Username:</td>
						<td><c:out value="${USERINFO.username}" /></td>
					</tr>

					<tr>
						<td>Password</td>
						<td><c:out value="${USERINFO.password}" /></td>
					</tr>

					<tr>
						<td>First Name</td>
						<td><c:out value="${USERINFO.firstName}" /></td>
					</tr>

					<tr>
						<td>Last Name</td>
						<td><c:out value="${USERINFO.lastName}" /></td>
					</tr>

					<tr>
						<td>UTA ID</td>
						<td><c:out value="${UTAID}" /></td>
					</tr>

					<tr>
						<td>Role</td>
						<td><c:out value="${ROLE}" /></td>
					</tr>

					<tr>
						<td>Phone</td>
						<td><c:out value="${USERINFO.phone}" /></td>
					</tr>

					<tr>
						<td>Email</td>
						<td><c:out value="${USERINFO.email}" /></td>
					</tr>

					<tr>
						<td>Street Address</td>
						<td><c:out value="${ADDRESS}" /></td>
					</tr>

					<tr>
						<td>City</td>
						<td><c:out value="${USERINFO.city}" /></td>
					</tr>

					<tr>
						<td>State</td>
						<td><c:out value="${USERINFO.state}" /></td>
					</tr>

					<tr>
						<td>Zip Code</td>
						<td><c:out value="${USERINFO.zipCode}" /></td>
					</tr>

					<tr>
					</tr>
				
			</td>
		</tr>
		<tr>
		<td></td>
			<td><a href="updateProfile.jsp" class="btn btn-danger">Update
					Profile</a></td>
		</tr>
	</table>
</body>
</html>