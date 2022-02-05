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
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Services</h3>
			<hr>
			<div class="container text-left">
				<!-- Add new user button redirects to the register.jsp page -->
				<a href="<%=request.getContextPath()%>/createService.jsp"
					class="btn btnsuccess">Add New Service</a>
			</div>
			<br>
			<!-- Create a table to list out all current users information -->
			<table class="table">
				<thead>
					<tr>
						<th>Service Name</th>
						<th>Service Image</th>
						<th>Service Price</th>
						<th>Service Description</th>
						<th>Actions</th>
					</tr>
				</thead>
				<!-- Pass in the list of users receive via the Servlet’s response to a loop
-->
				<tbody>
					<c:forEach var="service" items="${listServices}">
						<!-- For each user in the database, display their
information accordingly -->
						<tr>
							<td><c:out value="${service.serviceName}" /></td>
							<td><c:out value="${service.serviceImage}" /></td>
							<td><c:out value="${service.servicePrice}" /></td>
							<td><c:out value="${service.serviceDescription}" /></td>
							<!-- For each user in the database, Edit/Delete
buttons which invokes the edit/delete functions -->
							<td><a
								href="edit?serviceName=<c:out value='${service.serviceName}'
/>">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?serviceName=<c:out
value='${service.serviceName}' />">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>