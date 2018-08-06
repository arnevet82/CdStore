<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1255">
<title>Online Cds Store</title>
</head>
<body>
<form action="/clientLogin.do" method="post">
<p><font color="red">${errorMessage}</font></p>
First Name: <input type="text" name="firstName"/><br> 
Last Name: <input type="text" name="lastName"/> <br>
Email: : <input type="text" name="email"/><br> 
Password: <input type="password" name="password"/><br>
<input type="submit" value="login"/><br>
</form>
</body>
</html>