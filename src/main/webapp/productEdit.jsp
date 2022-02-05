<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>
	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> Product Management </a>
		</div>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/ProductServlet/dashboard"
				class="nav-link">Back to Dashboard</a></li>
		</ul>
	</nav>
	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<c:if test="${product != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${product == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${product != null}">Edit Product</c:if>
						<c:if test="${product == null}">Add New Product</c:if>
					</h2>
				</caption>
				<c:if test="${product != null}">
					<input type="hidden" name="oriProduct"
						value="<c:out value='${product.productName}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>Product's Name</label> <input type="text"
						value="<c:out value='${product.productName}' />" class="form-control"
						name="productName" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Image URL</label> <input type="text"
						value="<c:out value='${product.productImage}' />" class="form-control"
						name="productImage">
				</fieldset>
				<fieldset class="form-group">
					<label>Price</label> <input type="text"
						value="<c:out value='${product.productPrice}' />" class="form-control"
						name="productPrice">
				</fieldset>
				<fieldset class="form-group">
					<label>Description</label> <input type="text"
						value="<c:out value='${product.productDescription}' />" class="form-control"
						name="productDescription">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>