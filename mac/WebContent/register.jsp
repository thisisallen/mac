<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<li><a href="index.jsp">Home</a></li>
				<li><a href="register.jsp">Register</a></li>
				<li><a href="login.jsp">Login</a></li>
			</ul>
		</nav>
	</header>
	<main> 
	<input name="errMsg"
		value="<c:out value='${errorMsgs.errorMsg}'/>" type="text"
		style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60">
	<form action="/mac/UsersController?action=register" method="post">
		<table>
			<tr>
				<td><p>Username:</p></td>
				<td><input type="text"  name="username" value="<c:out value='${user.username}'/>"><br>
					<input name="errMsg"
					value="<c:out value='${errorMsgs.usernameError}'/>" type="text"
					style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"></td>

			</tr>
			<tr>
				<td><p>Password:</p></td>
				<td><input type="password" name="password" value="<c:out value='${user.password}'/>"><br>
					<input name="errMsg"
					value="<c:out value='${errorMsgs.passwordError}'/>" type="text"
					style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"></td>
			</tr>
			
			<tr>
				<td><p>First Name:</p></td>
				<td><input type="text"  name="firstName" value="<c:out value='${user.firstName}'/>"><br>
					<input name="errMsg"
					value="<c:out value='${errorMsgs.firstNameError}'/>" type="text"
					style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"></td>
			</tr>
			<tr>
				<td><p>Last Name:</p></td>
				<td><input type="text"  name="lastName" value="<c:out value='${user.lastName}'/>"><br>
					<input name="errMsg"
					value="<c:out value='${errorMsgs.lastNameError}'/>" type="text"
					style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"></td>
			</tr>
			<tr>
				<td><p>UTA ID</p></td>
				<td><input type="text"  name="utaID" value="<c:out value='${user.utaID}'/>"><br>
					<input name="errMsg"
					value="<c:out value='${errorMsgs.utaIDError}'/>" type="text"
					style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"></td>
			</tr>
			<tr>
				<td><p>Role:</p></td>
				<td><select name="role"> 
						<option value="1">User</option>
						<option value="2">Repairman</option>
						<option value="3">Facility Manager</option>
						<option value="4">Admin</option>
				</select></td>
			</tr>
			<tr>
				<td><p>Email Address:</p></td>
				<td><input type="text" name="email" value="<c:out value='${user.email}'/>"><br>
					<input name="errMsg"
					value="<c:out value='${errorMsgs.emailError}'/>" type="text"
					style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"></td>
			</tr>
			<tr>
				<td><p>Phone Number:</p></td>
				<td><input type="text"  name="phone" value="<c:out value='${user.phone}'/>"><br>
					<input name="errMsg"
					value="<c:out value='${errorMsgs.phoneError}'/>" type="text"
					style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"></td>
			</tr>
			<tr>
				<td><p>Street Address:</p></td>
				<td><input type="text" name="address" value="<c:out value='${user.address}'/>"><br>
					<input name="errMsg"
					value="<c:out value='${errorMsgs.streetError}'/>" type="text"
					style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"></td>
			</tr>
			<tr>
				<td><p>City:</p></td>
				<td><input type="text"  name="city" value="<c:out value='${user.city}'/>"><br>
					<input name="errMsg"
					value="<c:out value='${errorMsgs.cityError}'/>" type="text"
					style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60">
				</td>
			</tr>
			<tr>
				<td><p>State:</p></td>
				<td><select name="state" >
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
			<tr>
				<td><p>Zip/Postal Code</p></td>
				<td><input type="text"  name="zipCode" value="<c:out value='${user.zipCode}'/>"><br>
					<input name="errMsg"
					value="<c:out value='${errorMsgs.zipError}'/>" type="text"
					style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"></td>
			</tr>
			<tr>
				<td><button type="reset" class="btn btn-danger">Clear</button></td>
				<td><input type="submit" name="submit" value="register"></td>
			</tr>
		</table>
	</form>
	</main>
</body>
</html>