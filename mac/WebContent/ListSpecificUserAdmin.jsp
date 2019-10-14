<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MAC | ADMIN</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!--JQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- latest compiled Javascript-->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="style.css">
<header> <a href="home.php"><img class="logo" src="uta.png"
	alt="logo"></a> <nav>
<ul>
	<li><a href="adminHome.jsp">Home</a></li>
	<li><a href="/mac/AdminController?action=listUsers">View Other
			Users</a></li>
	<li><a href="/mac/UsersController?action=viewProfile">My
			Profile</a></li>
	<li><a href="/mac/UsersController?action=logout">Logout</a></li>
</ul>
</nav> </header>
<div class="header_resize">
	<h4>
		<a href="/mac/index1.jsp">Edit User profile</a>
	</h4>
	<br>
</head>
<body>
	<table>
		<tr>

			<td>Username:</td>
			<td><c:out value="${USERS.username}" /></td>
		</tr>

		<tr>
			<td>First Name:</td>
			<td><c:out value="${USERS.firstName}" /></td>
		</tr>

		<tr>
			<td>Last Name:</td>
			<td><c:out value="${USERS.lastName}" /></td>
		</tr>
		<tr>
			<td>Role:</td>
			<td><c:out value="${ROLE}" /></td>
		</tr>
		<tr>
			<td>Phone:</td>
			<td><c:out value="${USERS.phone}" /></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><c:out value="${USERS.email}" /></td>
		</tr>
		<tr>
			<td><a href="/mac/AdminController?action=listUsers"
				class="btn btn-info">BACK</a></td>
			<td><a
				href="/mac/AdminController?action=listSpecificUser2&id=${USERS.username}"
				class="btn btn-danger">EDIT</a></td>
		</tr>

	</table>



</body>
</html>