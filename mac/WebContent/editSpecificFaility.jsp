<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Company form</title>
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
		<a href="/mac/index1.jsp">EDIT Facility</a>
	</h4>
	<br>
</head>
<body>
	<form action="/mac/FacilityManagerController?action=editFacilities&id=${USERS.facilityName}" method="post">
		<table border="1" class="myTable">
					<tr>
						<td>Facility Name:</td>
				<td><c:out value="${USERS.facilityName}" /></td>
						
					</tr>

					<tr>
						<td>Facility Type:</td>
						<td>
							<select name="type" required="required">
								<option>${USERS.facilityType}</option>
								<option value="Badminton Court">Badminton Court</option>
								<option value="Conference Room">Conference Room</option>
								<option value="Indoor Basketball Court">Indoor Basketball
									Court</option>
								<option value="Indoor Volleyball Court">Indoor Volleyball
									Court</option>
								<option value="Multipurpose Room">Multipurpose Room</option>
								<option value="Outdoor Basketball Court">Outdoor
									Basketball Court</option>
								<option value="Outdoor Volleyball Court">Outdoor
									Volleyball Court</option>
								<option value="Racquetball Court">Racquetball Court</option>
								<option value="Indoor Soccer Gymnasium">Indoor Soccer
									Gymnasium</option>
								<option value="Table Tennis">Table Tennis</option>
							</select>
						</td>
						</tr>
						<tr>
							<td>Duration:</td>
							<td><select name="duration" required="required">
										<option>${USERS.duration}</option>
										<option value="Same Day">Same Day</option>
										<option value="7 Days">7 Days</option>
								</select></td>
							
						</tr>
						<tr>
							<td>Time Interval:</td>
							<td><select name="timeInterval" required="required">
										<option>${USERS.timeInterval}</option>
										<option value="30 minutes">30 minutes</option>
										<option value="1 hour">1 hour</option>
										<option value="2 hours">2 hours</option>
								</select></td>
							
						</tr>
						<tr>
							<td>Venue:</td>
							<td><select name="venue" required="required">
										<option>${USERS.venue}</option>
										<option value="Indoor">Indoor</option>
										<option value="Outdoor">Outdoor</option>
								</select>
							</td>
										
						</tr>
						<tr>
							<td><a href="/mac/FacilityManagerController?action=listFacilities" class="btn btn-info">BACK</a></td>
							<td><input type="submit" value="edit"></td> 
						</tr>
		</form>
	</body>
</html>