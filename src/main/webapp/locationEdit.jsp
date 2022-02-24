<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Edit Shop Location</title>
</head>

<body>

	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> Pet Shop Location Management Application
			</a>
		</div>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/locationServlet/dashboard"
				class="nav-link">Back to Dashboard</a></li>
		</ul>
	</nav>

	<h1 style="text-align: center;">Edit a Pet Shop Location</h1>


	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<c:if test="${location != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${location == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${location != null}">
Edit Pet Shop Details
</c:if>
						<c:if test="${location == null}">
Add New Pet Shop Location
</c:if>
					</h2>
				</caption>
				<c:if test="${location != null}">
					<input type="hidden" name="oriShopName"
						value="<c:out value='${location.shopName}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>Shop Name</label> <input type="text"
						value="<c:out value='${location.shopName}' />" class="form-control"
						name="shopName" id="editShopName" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Shop Image</label> <input type="text"
						value="<c:out value='${location.shopImage}' />" class="form-control"
						name="shopImage" id="editShopImage">
				</fieldset>
				<fieldset class="form-group">
					<label>Shop Location</label> <input type="text"
						value="<c:out value='${location.shopLocation}' />" class="form-control"
						name="shopLocation" id="editShopLocation">
				</fieldset>
				<fieldset class="form-group">
					<label> Shop Description</label> <input type="text"
						value="<c:out value='${location.shopDescription}' />" class="form-control"
						name="shopDescription" id="editShopDescription">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>