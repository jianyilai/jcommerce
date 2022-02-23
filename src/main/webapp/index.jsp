<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Pet Products</title>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body>

	<div class="text-center">
		<a href="<%=request.getContextPath()%>/register.jsp" class="nav-link">Register
			an Account</a> <a href="<%=request.getContextPath()%>/login.jsp"
			class="nav-link">Login</a> 
			<a href="<%=request.getContextPath()%>/AccountServlet/dashboard"
			class="nav-link">Manage Accounts</a>
			<a
			href="<%=request.getContextPath()%>/locationServlet/dashboard"
			class="nav-link">View Shop Locations</a> <a
			href="<%=request.getContextPath()%>/ServiceServlet/dashboard"
			class="nav-link">View Services Offered</a>
	</div>

	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Products</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/createProduct.jsp"
					class="nav-link">Add a New Product</a>
			</div>
			<br>

			<table class="table">
				<thead>
					<tr>
						<th>Product name</th>
						<th>Product image</th>
						<th>Product price</th>
						<th>Product description</th>
						<th>Actions</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="product" items="${listProducts}">
						<!-- For each user in the database, display their information accordingly -->
						<tr>
							<td><c:out value="${product.productName}" /></td>
							<td><img src="<c:out value="${product.productImage}"/>"
								style="width: 60%"></td>
							<td>$<c:out value="${product.productPrice}" /></td>
							<td><c:out value="${product.productDescription}" /></td>

							<!-- For each user in the database, Edit/Delete buttons which invokes the edit/delete functions -->
							<td><a
								href="edit?productName=<c:out value='${product.productName}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?productName=<c:out value='${product.productName}'  />">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>