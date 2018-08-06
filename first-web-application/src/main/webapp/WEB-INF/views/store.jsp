<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Cds Store - Management Page</title>
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
			<li class="active"><a href="#">Cd Inventory and Customers List</a></li>
		</ul>
		<ul class="nav navbar-nav">
			<li class="active"><a href="/cd.do?firstName=Admin">Store</a></li>
		</ul>
		

		<ul class="nav navbar-nav navbar-right">
			<li><a href="/adminLogin.do">Administrator Login</a></li>
		</ul>

	</nav>

	<div class="container">
		<h3>Cds Store - Management Page</h3>
		<h4>Cds in Inventory:</h4>
		
		<table>
		    <tr>
		        <th>Id</th>
		        <th>Name</th>
		        <th>Price</th>
		        <th>Amount</th>
		        <th></th>
		    </tr>
		    
		    <c:forEach items="${cds}" var="cd" varStatus="status">
		        <tr>
		            <td>${cd.id}&nbsp;&nbsp;&nbsp;</td>
		            <td>${cd.name}&nbsp;&nbsp;&nbsp;</td>
		            <td>${cd.price}&nbsp;&nbsp;&nbsp;</td>
		            <td>${cd.amount}&nbsp;&nbsp;&nbsp;</td>
		            <td><a href="/delete-cd.do?id=${cd.id}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Delete</a></td>
		        </tr>
		        
		    </c:forEach>
		</table>
		
		
		<p>
			<font color="red">${errorMessage}</font>
		</p>
		
		<form method="POST" action="/store.do">
			Add new Cd :  name <input name="cd" type="text" />  
			price <input type="number" min="0" max="999.00" step="1.00" name="price" />
			Amount <input type="number" min="0" max="999.00" step="1" name="amount" /> <input name="add"
				type="submit" value="Add"/>
		</form>
		
		<h4>Customers:</h4>
		<ol>
			<c:forEach items="${clients}" var="client">
				<li>${client.firstName}&nbsp;${client.lastName}&nbsp;&nbsp;<a
					href="/client.do?email=${client.email}">View Client</a></li>
			</c:forEach>
		</ol>
	</div>


	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>