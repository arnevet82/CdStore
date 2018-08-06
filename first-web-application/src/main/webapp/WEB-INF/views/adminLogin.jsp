<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1255">
<title>Online Cds Store</title>
</head>
<body>
<form action="/adminLogin.do" method="post">
<p><font color="red">${errorMessage}</font></p>
Name: <input type="text" name="name"/> Password: <input type="password" name="password"/><input type="submit" value="login"/>
</form>
</body>
</html>