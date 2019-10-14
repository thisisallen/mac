<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MAC | REGISTER</title>
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
	<main>
	<form action="/mac/FacilityManagerController?action=addFacility"
		method="post">
		<table>
			<tr>
				<td><label>Facility Name:</label></td>
				<td><input type="text" required="required" name="fac_name"></td>
			</tr>
			<tr>
				<td><label>Facility Type:</label></td>
				<td><select name="fac_type" required="required">
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
				</select></td>
			</tr>
			<tr>
				<td><label>Time Interval:</label></td>
				<td><select name="timeInterval" required="required">
						<option value="30 minutes">30 minutes</option>
						<option value="1 hour">1 hour</option>
						<option value="2 hours">2 hours</option>
				</select></td>
			</tr>
			<tr>
				<td><label>Duration:</label></td>
				<td><select name="duration" required="required">
						<option value="Same Day">Same Day</option>
						<option value="7 Days">7 Days</option>
				</select></td>
			</tr>
			<tr>
				<td><label>Venue:</label></td>
				<td><select name="venue" required="required">
						<option value="Indoor">Indoor</option>
						<option value="Outdoor">Outdoor</option>
				</select></td>
			</tr>


			<tr>
				<td></td>
				<td><input type="submit" name="submit" class="btn btn-danger"
					value="ADD"></td>
			</tr>

			<tr>


			</tr>
		</table>
	</form>
	</main>
</body>
</html>