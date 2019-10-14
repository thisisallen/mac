<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MAC | LOGIN</title>
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
				<li><a href="index.jsp">Home</a></li>
				<li><a href="register.jsp">Register</a></li>
				<li><a href="login.jsp">Login</a></li>
			</ul>
		</nav>
	</header>
	<main>
	<input  value="${LOGIN_ERROR}" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60">
		
	<form action="/mac/UsersController?action=login" method="post">
		<table>
			<tr>
				<td><p>Username:</p></td>
				<td><input type="text"  name="username"><br>
					<input name="errMsg"
					value="<c:out value='${errorMsgs.usernameError}'/>" type="text"
					style="background-color: white; color: red; border: none; width: 300px"
					disabled="disabled"></td>
			</tr>
			<tr>
				<td>
					<p>Password:</p>
				</td>
				<td><input type="password"  name="password"><br>
					<input name="errMsg"
					value="<c:out value='${errorMsgs.passwordError}'/>" type="text"
					style="background-color: white; color: red; border: none; width: 300px"
					disabled="disabled"></td>
			</tr>
			<tr>
			<td></td>
				<td>
					<p></p>
					<button type="submit">Login</button>
				</td>
			</tr>
		</table>
	</form>
	</main>
</body>
</html>