<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Locations</title>
</head>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box;
}

input[type=text], select, textarea {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-top: 6px;
	margin-bottom: 16px;
	resize: vertical;
}

input[type=submit] {
	background-color: #8A95A5;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
</style>
<body>

	<h1 style="text-align: center; ">Add a Pet Shop Location</h1>
	

	<div class="container">
		<form action="addShopLocationServlet" method="post">
			<label for="sName">Shop Name</label> <input type="text" 
				name="shopName"> 
				
				<label for="sImage">Shop
				Image</label><input type="text"  name="shopImage">
				
				<label for="sLocation">Shop
				Location</label><input type="text" name="shopLocation">
				
				
				 <label for="sDescription">Shop Description</label>
			<textarea name="shopDescription"
				style="height: 200px"></textarea>

			<input type="submit" value="Call Servlet">
		</form>
	</div>

</body>
</html>