<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a new product</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

<nav class="navbar navbar-expand-md navbar-light">
<div>
<a class="navbar-brand"> Add a new product </a>
</div>
<ul class="navbar-nav">
<li><a href="<%=request.getContextPath()%>/index.jsp"
class="nav-link">Back to Products</a></li>
</ul>
</nav>
<div class="container col-md-6">
<div class="card">
<div class="card-body">
<form action="NewProductServlet" method="post">
<fieldset class="form-group">
<label>Product Name</label> <input type="text" class="form-control" name="productName" required="required">
</fieldset>
<fieldset class="form-group">
<label>Product Image URL</label> <input type="text" class="form-control" name="productImage" required="required">
</fieldset>
<fieldset class="form-group">
<label>Product Price</label> <input type="text" class="form-control" name="productPrice" required="required">
</fieldset>
<fieldset class="form-group">
<label>Product Description</label> <input type="text" class="form-control" name="productDescription" required="required">
</fieldset>
<button type="submit" class="btn btn-success">Add</button>
</form>
</div>
</div>
</div>
</body>
</html>