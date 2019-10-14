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
<body>

	<table border="1" class="myTable">
		<tr class="myTableRow">


			<th class="myTableHead" style="padding-right: 35px; text-align: left">Facility Name</th>
			<th class="myTableHead" style="padding-right: 20px; text-align: left">Facility Type</th>
			<th class="myTableHead" style="padding-right: 20px; text-align: left">Time Interval</th>
			<th class="myTableHead" style="padding-right: 30px; text-align: left">Duration</th>
			<th class="myTableHead" style="padding-right: 30px; text-align: left">Venue</th>
			<th class="myTableHead" style="padding-right: 30px; text-align: left"></th>

		</tr>

		<c:forEach items="${USER}" var="item" varStatus="status">
			<tr class="myTableRow">

				<td class="myTableCell" style="padding-right: 35px;"><c:out
						value="${item.facilityName}" /></td>
				<td class="myTableCell" style="padding-right: 20px;"><c:out
						value="${item.facilityType}" /></td>
				<td class="myTableCell" style="padding-right: 20px;"><c:out
						value="${item.timeInterval}" /></td>
				<td class="myTableCell" style="padding-right: 30px;"><c:out
						value="${item.duration}" /></td>
				<td class="myTableCell" style="padding-right: 30px;"><c:out
						value="${item.venue}" /></td>
				<td><a
					href="/mac/FacilityManagerController?action=listSpecificFacility&id=${item.facilityName}">View</a></td>

			</tr>
		</c:forEach>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><a href="addFacility.jsp" class="btn btn-info">ADD</a></td>
		</tr>
	</table>



</body>
<footer>
	<div class="footer1">
		<hr>
		<p></p>
	</div>
</footer>
</html>