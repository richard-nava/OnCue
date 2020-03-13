<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="static/styles.css" type="text/css">

<title>OnCue Sign Up</title>
</head>
<body>

	<div>
	<jsp:include page="header.jsp"></jsp:include>
	</div>
	
	
	<div class="card center">
			<div class="card-body">
					<div>
						<h2>Sign up!</h2>
						<p>It's free. And always will be.
						<small>...until I get like a ton of users. Then i might make you give me a dollar or something.</small>
						
						
					</div>
				${error}
				<form:form action="signup" modelAttribute="user" method="post">
				    <form:input type="hidden" path="id"/>
					<div class="form-group">
				   	 <label for="exampleFname">First Name</label>
				  	  <form:input type="text" path="firstName" class="form-control" id="exampleFname" aria-describedby="emailHelp"/>  
				    </div>
				    <div class="form-group">
					    <label for="exampleInputLname">Last Name</label>
					    <form:input type="text" path="lastName" class="form-control" id="exampleLname" aria-describedby="emailHelp"/>
					</div>
				    <div class="form-group">
				 	   <label for="exampleUser">Desired Username</label>
				 	   <form:input type="text" path="username" class="form-control" id="exampleUsername" aria-describedby="emailHelp"/>
				    </div>
				    <div class="form-group">
					     <label for="exampleInputEmail1">Email address</label>
					    <form:input type="email" path="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"/>
				 	   <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone.</small>
				    </div>
				    <div class="form-group">
					    <label for="exampleInputPassword1">Password</label>
					    <form:input type="password" path="password"  class="form-control" id="exampleInputPassword1"/>
			  	    </div>
				  <button type="submit" class="btn btn-primary">Submit</button>
				</form:form>
			</div>
		</div>
	
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>