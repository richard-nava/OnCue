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
<title>${org.orgName}</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div class="container justify-content-center">
		<div class="card org-card mb-3">
			<img class="card-img-top org-img center" src="static/img/org/${org.id}/profile/${org.image}" alt="Card image cap">
			<div class="card-body text-center">
				<h4 class="card-title">${org.orgName} Manager</h4>
				<p class="card-text">
					<small class="text-muted"></small>
				</p>
			</div>
		</div>
	</div>
	
	<br>

	<div class="container ">
		<div class="row d-flex justify-content-center" style="padding-top: 10px;">
			
			<div class="card classes-card card-profile col-2 border-dark text-center"
				style="width: 5rem;">

				<img class="center-image"
					src="https://img.icons8.com/ios/50/000000/class.png" alt="Classes"
					style="padding-top: 40px;">
				<div class="card-body">
					<h5 class="card-title">Classes</h5>
					
					<a id="btnGroupDrop1" type="button"
						class="btn stretched-link dropdown-toggle" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"></a>
					<div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
						<c:forEach var="var" items="${classes}">
							<a class="dropdown-item" id="${var.class_id}"
								href="class-page?id=${var.class_id}">${var.class_name}</a>
						</c:forEach>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="add-class" role="button">New
							Class</a>
					</div>
				</div>
			</div>

			<div class="card students-card card-profile col-2 border-dark text-center"
				style="width: 5rem;">

				<img class="center-image"
					src="https://img.icons8.com/material/48/000000/user-menu-male--v1.png"
					alt="Students" style="padding-top: 40px;">
				<div class="card-body">
					<h5 class="card-title">Students</h5>
					<a id="btnGroupDrop1" type="button"
						class="btn stretched-link dropdown-toggle" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"></a>
					<div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
						<a class="dropdown-item" href="view-students" role="button">View
							All</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="add-student" role="button">Add
							Student</a>

					</div>
				</div>
			</div>

			

					<div class="card signin-card card-profile col-2 border-dark text-center"
						style="width: 10rem;">
						<img class="center-image"
							src="static/img/icons/BlackClock.png"
							style="padding-top: 40px;"
							alt="Sign In Page">
						<div class="card-body">
							<h5 class="card-title">Sign-In Page</h5>
							<a href="org-signin" class="stretched-link"></a>
						</div>
					</div>

					<div class="card settings-card card-profile col-2 border-dark text-center"
						style="width: 10rem;">
						<img class="center-image"
							src="https://img.icons8.com/material-outlined/48/000000/vertical-settings-mixer.png" style="padding-top: 40px;"
							alt="Organization Settings">
						<div class="card-body">
							<h5 class="card-title">Settings</h5>
							<a href="organization-settings" class="stretched-link"></a>
						</div>
					</div>
				</div>
				</div>
		
		




<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>

			<script src="content/js/jquery.min.js"></script>
<script src="content/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function () {
        $('.dropdown-toggle').dropdown();
    });
</script>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>