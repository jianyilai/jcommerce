<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/ProductServlet/dashboard"
				class="nav-link">Back to Products</a></li>
		</ul>
<form action="RegisterServlet" method="post">
	Username: <input type="text" name="username"><br>
	Password: <input type="password" name="password"><br>
	Email: <input type="text" name="email"><br>
	<br>
	<input type="submit" value="Create Account">
</form>
</body>
</html>