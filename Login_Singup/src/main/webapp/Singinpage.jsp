<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>LogIn Page!</h1>
	<form action="Logindata" method="post">
		Enter your Username:
		<input type="text" name="uname"><br><br>
		Enter your Password
		<input type="password" name="pass"><br><br>
		
		<input type="submit" value="Login"><br><br>
		
		Don't have an account?
		<a href="Singup.jsp"> SingUp</a>
	
	</form>
</body>
</html>