<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Client Page</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

<style>
	.footer {
		position: absolute;
		bottom: 0;
		width: 100%;
		height: 60px;
		background-color: #f5f5f5;
	}
</style>
</head>

<body>

	<nav class="navbar navbar-default">

		<ul class="nav navbar-nav">
			<li class="active"><a href="#">Client Page</a></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li><a href="/adminlogin.do">Administrator Login</a></li>
		</ul>

	</nav>

	<div class="container">
		<h5>Client: ${client.firstName}&nbsp;${client.lastName}</h5>
		<br>
		<h5>Email: ${client.email}</h5>
		<br>
		<h5>Password: ${client.password}</h5>
		<br>
		<h5>Purchases: ${client.cds}</h5>
		<p>
			<font color="red">${errorMessage}</font>
		</p>
		
	</div>


	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>