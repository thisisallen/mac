<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MAC | ADMIN</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    
     <!--JQuery library -->
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

     <!-- latest compiled Javascript-->
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="style.css">
</head>
<body>
<header>
		<nav>
			<ul>
				<li><a href="adminHome.jsp">Home</a></li>
				<li><a href="/mac/AdminController?action=listUsers">View Other Users</a></li>
				<li><a href="/mac/UsersController?action=viewProfile">My Profile</a></li>
				<li><a href="/mac/UsersController?action=logout">Logout</a></li>
			</ul>
		</nav>
	</header>
	<main>

       <form action="/mac/AdminController?action=searchSpecificUser"
		method="post">
		<h5>SEARCH USER</h5>
		<input name="errMsg" value="<c:out value='${errorMsgs.nameError}'/>"
			type="text"
			style="background-color: white; color: red; border: none; width: 800px"
			disabled="disabled"> <label>Enter Last Name</label> <input
			type="text" name="last"><br> <input type="submit"
			name="submit" value="SEARCH">
	</form>
       <table border="1" class="myTable"> 
			<tr class="myTableRow"> 
				
			
				<th class="myTableHead" style="padding-right: 35px; text-align: left">First name</th> 
				<th class="myTableHead" style="padding-right: 20px; text-align: left">last Name</th>
					
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Username</th> 
				<th class="myTableHead" style="padding-right: 30px; text-align: left"></th> 
			</tr>

 		<c:forEach items="${USER}" var="item" varStatus="status">
			<tr class="myTableRow">
			
			<td class="myTableCell" style="padding-right: 35px; "><c:out value="${item.firstName}" /></td>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.lastName}" /></td>
			
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.username}" /></td>
			
            <td> <a href="/mac/AdminController?action=listSpecificUser&id=${item.username}">View</a></td>
			</tr>
		</c:forEach>
 </table>
	
	</main>
</body>
<footer>
	<div class="footer1">
<hr>
	<p> 
	</p>
</div>
</footer>

</html>