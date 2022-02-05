<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="createServiceServlet" method="post">
Name: <input type="text" name="serviceName">
Image: <input type="text" name="serviceImage">
Price: <input type="text" name="servicePrice">
Description: <input type="text" name="serviceDescription">
<input type="submit" value="Create" />
</form>
</body>
</html>