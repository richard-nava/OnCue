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
<link rel="stylesheet" href="static/styles.css" type="text/css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<title>Welcome to OnCue</title>
</head>
<body class="signup-body">

	<!-- HEADER -->
	<div>
	<jsp:include page="header.jsp"></jsp:include>
	</div>
	<!-- END HEADER -->

	
	<div class="container">
		<div class="row">
		
			<img class="main-image" src="static/img/DisplayLogo_Blue.png" alt="Card image cap" style="margin-top: 20px; margin-top:20px;">
		</div>
<!-- 
			<div class="col-8 offset-2">
				<div class="card center card-home"> style="width: 18rem;"
					<img class="card-img-top" src="static/img/DisplayLogo_Blue.png" alt="Card image cap" style="margin-top: 20px">
					<div class="card-body text-center">
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">Go somewhere</a>
					</div>
				</div>
			</div> -->

			<div class="container">
		
		<div class="row" style="padding-top: 60px;">
		
			<div class="col-sm">
				<div class="card card-info border-dark text-center" style="width: 18rem;">
					<img class="center-image" src="https://img.icons8.com/metro/45/000000/check-all.png" />
					<div class="card-body">
						<h5 class="card-title">Sign-In Tracker</h5>
						<p class="card-text">Accurately records when attendee's for your classes or events sign in. 
						View every sign in for any day, time, class, or event.</p>
<!-- 						<a href="#" class="btn btn-primary">Go somewhere</a>
 -->					</div>
				</div>
			</div>
			
			<div class="col-sm">
				<div class="card card-info border-dark text-center" style="width: 18rem;">
					<img  class="center-image" src="https://img.icons8.com/material-rounded/52/000000/user-menu-male.png" />
					<div class="card-body">
						<h5 class="card-title">Profiles</h5>
						<p class="card-text">Create, edit, and save info of your users. Keep a 
						record of their sign-ins and monitor what they can sign in to.</p>
						<!-- <a href="#" class="btn btn-primary">Go somewhere</a> -->
					</div>
				</div>
			</div>
			<div class="col-sm">
				<div class="card card-info border-dark text-center" style="width: 18rem;">
					<img class="center-image"src="https://img.icons8.com/material-rounded/48/000000/login-rounded-down.png" />
					<div class="card-body">
						<h5 class="card-title">Intuitive Interaction</h5>
						<p class="card-text">Whether signing in to a class, managing an organization, or viewing class 
						attendance, OnCue's workflow is intuitive and simple to use.
						 </p>
					</div>
				</div>
			</div>
		</div>
		</div>
	</div>


<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>