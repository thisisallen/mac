<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MAC | PROFILE</title>
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
	<form action="/mac/UsersController?action=updateProfile" method="post">
		<table border="1" class="myTable">
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username" placeholder="${USERINFO.username}" /></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><input type="password" name="password" placeholder="${USERINFO.password}" /></td>
			</tr>

			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" placeholder="${USERINFO.firstName}" /></td>
			</tr>

			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName" placeholder="${USERINFO.lastName}" /></td>
			</tr>

			<tr>
				<td>UTA ID</td>
				<td><input type="text" name="utaID" placeholder="${UTAID}" /></td>
			</tr>

			<tr>
				<td>Phone</td>
				<td><input type="tel" name="phone" placeholder="${USERINFO.phone}" /></td>
			</tr>

			<tr>
				<td>Email</td>
				<td><input type="email" name="email" placeholder="${USERINFO.email}" /></td>
			</tr>

			<tr>
				<td>Street Address</td>
				<td><input type="text" name="address" placeholder="${ADDRESS}" /></td>
			</tr>

			<tr>
				<td>City</td>
				<td><input type="text" name="city" placeholder="${USERINFO.city}" /></td>
			</tr>

			<tr>
				<td>State</td>
				<td><select name="state" required=required>
						<option>${USERINFO.state}</option>
						<option value="AL">Alabama</option>
						<option value="AK">Alaska</option>
						<option value="AZ">Arizona</option>
						<option value="AR">Arkansas</option>
						<option value="CA">California</option>
						<option value="CO">Colorado</option>
						<option value="CT">Connecticut</option>
						<option value="DE">Delaware</option>
						<option value="DC">District Of Columbia</option>
						<option value="FL">Florida</option>
						<option value="GA">Georgia</option>
						<option value="HI">Hawaii</option>
						<option value="ID">Idaho</option>
						<option value="IL">Illinois</option>
						<option value="IN">Indiana</option>
						<option value="IA">Iowa</option>
						<option value="KS">Kansas</option>
						<option value="KY">Kentucky</option>
						<option value="LA">Louisiana</option>
						<option value="ME">Maine</option>
						<option value="MD">Maryland</option>
						<option value="MA">Massachusetts</option>
						<option value="MI">Michigan</option>
						<option value="MN">Minnesota</option>
						<option value="MS">Mississippi</option>
						<option value="MO">Missouri</option>
						<option value="MT">Montana</option>
						<option value="NE">Nebraska</option>
						<option value="NV">Nevada</option>
						<option value="NH">New Hampshire</option>
						<option value="NJ">New Jersey</option>
						<option value="NM">New Mexico</option>
						<option value="NY">New York</option>
						<option value="NC">North Carolina</option>
						<option value="ND">North Dakota</option>
						<option value="OH">Ohio</option>
						<option value="OK">Oklahoma</option>
						<option value="OR">Oregon</option>
						<option value="PA">Pennsylvania</option>
						<option value="RI">Rhode Island</option>
						<option value="SC">South Carolina</option>
						<option value="SD">South Dakota</option>
						<option value="TN">Tennessee</option>
						<option value="TX">Texas</option>
						<option value="UT">Utah</option>
						<option value="VT">Vermont</option>
						<option value="VA">Virginia</option>
						<option value="WA">Washington</option>
						<option value="WV">West Virginia</option>
						<option value="WI">Wisconsin</option>
						<option value="WY">Wyoming</option>
				</select></td>
			</tr>
			</tr>

			<tr>
				<td>Zip Code</td>
				<td><input type="text" name="zipCode" placeholder="${USERINFO.zipCode}"/></td>
			</tr>

			<tr>
				<td><input type="submit" class="btn btn-danger" value="Confirm Changes">
				<a href="/mac/UsersController?action=viewProfile" class="btn btn-info">BACK</a></td>
			</tr>

		</table>
	</form>

</body>
</html>