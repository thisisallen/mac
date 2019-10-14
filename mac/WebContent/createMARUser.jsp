<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http:
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
	<input name="error"  type="text" value="${MSG}" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60">
	<form action="/mac/UsersController?action=createMAR" method="post">
		<table>
			<tr>
				<td>
					<p>Facility Name:</p>
				</td>
				<td><select name="facilityName"> 
						<option value="BMC1">BMC1</option>
						<option value="BMC2">BMC2</option>
						<option value="BMC3">BMC3</option>
						<option value="BMC4">BMC4</option>
						<option value="BMC5">BMC5</option>
						<option value="BMC6">BMC6</option>
						<option value="BMC7">BMC7</option>
						<option value="BMC8">BMC8</option>
						<option value="BMC9">BMC9</option>
						<option value="BMC10">BMC10</option>
						<option value="CR1">CR1</option>
						<option value="CR2">CR2</option>
						<option value="CR3">CR3</option>
						<option value="CR4">CR4</option>
						<option value="CR5">CR5</option>
						<option value="IBBC1">IBBC1</option>
						<option value="IBBC2">IBBC2</option>
						<option value="IBBC3">IBBC3</option>
						<option value="IBBC4">IBBC4</option>
						<option value="IBBC5">IBBC5</option>
						<option value="IVBC1">IVBC1</option>
						<option value="IVBC2">IVBC2</option>
						<option value="IVBC3">IVBC3</option>
						<option value="IVBC4">IVBC4</option>
						<option value="IVBC5">IVBC5</option>
						<option value="IVBC6">IVBC6</option>
						<option value="IVBC7">IVBC7</option>
						<option value="IVBC8">IVBC8</option>
						<option value="IVBC9">IVBC9</option>
						<option value="MR1">MR1</option>
						<option value="MR2">MR2</option>
						<option value="MR3">MR3</option>
						<option value="MR4">MR4</option>
						<option value="OBBC1">OBBC1</option>
						<option value="OBBC2">OBBC2</option>
						<option value="OVBC1">OVBC1</option>
						<option value="OVBC2">OVBC2</option>
						<option value="RBC1">RBC1</option>
						<option value="RBC2">RBC2</option>
						<option value="RBC3">RBC3</option>
						<option value="RBC4">RBC4</option>
						<option value="RBC5">RBC5</option>
						<option value="SCG">SCG</option>
						<option value="TT1">TT1</option>
						<option value="TT2">TT2</option>
						<option value="TT3">TT3</option>
				</select></td>
			</tr>
			<tr>
				<td>
					<p>Urgency:</p>
				</td>
				<td><select name="urgency" required=required>
						<option value="Minor">Minor</option>
						<option value="Medium">Medium</option>
						<option value="Major">Major</option>
						<option value="Unusable">Unusable</option>
				</select></td>
			</tr>
			<tr>
				<td>
					<p>Description:</p>
				</td>
				<td><input type="text"  name="description">
				</td>
			</tr>
			<tr>
				<td>
					<p>Date:</p>
				</td>
				<td><input type="date"  name="date">
				</td>
			</tr>
			<tr>
			<td></td>
				<td>
					<button type="submit">Create</button>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>