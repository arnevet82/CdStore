<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Cd Store</title>
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
			<li class="active"><a href="#">Home</a></li>
		</ul>

		
	</nav>

	<div class="container">
		<H3>Welcome to our online store</H3><br>
		<H4>Please select:</H4><br>
		<a href="/clientLogin.do">I am a Customer&nbsp;&nbsp;&nbsp;</a>
		<a href="/adminLogin.do">&nbsp;&nbsp;&nbsp;&nbsp;I am Admin</a>
		
	</div>

	<footer class="footer">
		<p>All rights reserved:)</p>
	</footer>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>