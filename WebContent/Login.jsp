<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="/LoginRegister_App/forms.css">
</head>
<body>
	<div style="text-align: center;">
		<h1 class="login">Login!</h1>
		<form action='<%= request.getContextPath() %>/LoginServlet' method='post'>
			<input type='text' placeholder='username' name='username'>
			<input type='password' placeholder='password' name='password'>
			<input type='submit' value='login'>
		</form>
	</div>
	<div style="text-align:center;">
		<p>Don't Have An Account?</p>
		<a href="/LoginRegister_App/RegisterServlet">Register Here</a>
	</div>
</body>
</html>