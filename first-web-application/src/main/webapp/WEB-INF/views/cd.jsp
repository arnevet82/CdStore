<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Cds Store</title>
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
			<li class="active"><a href="#">Our Cd Collection</a></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li><a href="/adminLogin.do">Administrator Login</a></li>
		</ul>

	</nav>

	<div class="container">
		<h4>Welcome to our Online Cd Store, ${firstName}</h4><br>
		<h4>Our Available Cds:</h4><br>
		
		
		<table>
		    <tr>
		        <th>Name</th>
		        <th>Price</th>
		        <th></th>
		    </tr>
		    
		    <c:forEach items="${cds}" var="cd" varStatus="status">
		        <tr>
		            <td>${cd.name}&nbsp;&nbsp;&nbsp;</td>
		            <td>${cd.price}$&nbsp;&nbsp;&nbsp;</td>
		            <td><a href="/buy-cd.do?id=${cd.id}&email=${email}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Buy</a></td>
		        </tr>
		        
		    </c:forEach>
		</table><br>
		
		<p>
			<font color="red">${errorMessage}</font>
		</p>
		
		<h4>You bought:</h4>
		<ol>
			<c:forEach items="${currentlyBoughtCds}" var="cd">
				<li>${cd.name};&nbsp;&nbsp;${cd.price}$</li>
			</c:forEach>
		</ol>
		
		<form method="POST" action="/cd.do?remove=true">
			<input name="Checkout" type="submit" value="Checkout"/>
		</form>
	</div>

	<footer class="footer">
		<p>All rights reserved:)</p>
	</footer>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>
