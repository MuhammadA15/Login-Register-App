<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<div style="text-align: center;">
		<h1>Register!</h1>
		<form action='<%= request.getContextPath() %>/RegisterServlet' method='post'>
			<input type='text' placeholder='username' name='username'>
			<input type='password' placeholder='password' name='password'>
			<input type='submit' value='Register'>
		</form>
	</div>
	<div style="text-align: center;">
		<p>Already Have An Account?</p>
		<a href="/LoginRegister_App/LoginServlet">Login Here</a>
	</div>
</body>
</html>