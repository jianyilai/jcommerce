<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Service Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> Service Management Application </a>
		</div>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/ServiceServlet/dashboard"
				class="nav-link">Back to Dashboard</a></li>
		</ul>
	</nav>
	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<c:if test="${service != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${service == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${service != null}">
Edit service
</c:if>
						<c:if test="${service == null}">
Add New Service
</c:if>
					</h2>
				</caption>
				<c:if test="${service != null}">
					<input type="hidden" name="oriName"
						value="<c:out
value='${service.serviceName}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>Service Name</label> <input type="text"
						value="<c:out
value='${service.serviceName}' />"
						class="form-control" name="serviceName" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Service Image</label> <input type="text"
						value="<c:out
value='${service.serviceImage}' />"
						class="form-control" name="serviceImage">
				</fieldset>
				<fieldset class="form-group">
					<label>Service Price</label> <input type="text"
						value="<c:out
value='${service.servicePrice}' />"
						class="form-control" name="servicePrice">
				</fieldset>
				<fieldset class="form-group">
					<label> Service Description</label> <input type="text"
						value="<c:out
value='${service.serviceDescription}' />"
						class="form-control" name="serviceDescription">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>