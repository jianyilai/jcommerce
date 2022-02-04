<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>All Shops</title>
</head>
<body>

	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Pet Shop Locations</h3>
			<hr>
			<div class="container text-left">
				<!-- Add new user button redirects to the register.jsp page -->
				<a href="<%=request.getContextPath()%>/add_shop_location.jsp"
					class="btn btn-success">Add New Pet Shop 	Location</a>
			</div>
			<br>
			<!-- Create a table to list out all current users information -->
			<table class="table">
				<thead>
					<tr>
						<th>Shop Name</th>
						<th>Shop Image</th>
						<th>Shop Location</th>
						<th>Shop Description</th>
						<th>Actions</th>
					</tr>
				</thead>
				<!-- Pass in the list of users receive via the Servlet’s response to a loop -->
				<tbody>
					<c:forEach var="location" items="${listLocations}">
						<!-- For each user in the database, display their information accordingly -->
						<tr>
							<td><c:out value="${location.shopName}" /></td>
							<td><c:out value="${location.shopImage}" /></td>
							<td><c:out value="${location.shopLocation}" /></td>
							<td><c:out value="${location.shopDescription}" /></td>
							<!-- For each user in the database, Edit/Delete buttons which invokes the edit/delete functions -->
							<td><a href="edit?shopName=<c:out value='${location.shopName}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?shopName=<c:out value='${location.shopName}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>