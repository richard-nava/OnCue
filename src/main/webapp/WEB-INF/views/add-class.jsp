<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<title>Add a ${org.orgName} Class</title>
</head>
<body>

	<!-- HEADER -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- END HEADER -->

	<div class="container">
		<div class="card center">
			<div class="card-body">
				<div>
					<h2>Add a Class to ${org.orgName}'s Roster</h2>
				</div>
				${error}
				<form:form action="create-class" modelAttribute="newClass"
					method="post">
					<form:input type="hidden" path="class_id" />
					<div class="form-group">
						<label for="class_name">Class Name</label>
						<form:input type="text" path="class_name" class="form-control"
							id="class_name" aria-describedby="emailHelp" />
					</div>
					<div class="form-group">
						<label for="description">Description</label>
						<form:input type="text" path="description" class="form-control"
							id="description" aria-describedby="emailHelp" />
					</div>

					<label for="days">Days Available</label>
					<div class="row">
					<div class="form-group">
					<label for="days">Monday</label>
						<form:checkbox path="monday" />
					</div>
				
					<label for="days">Tuesday</label>
					<form:checkbox path="tuesday" />
					
					<div class="form-group">
					<label for="days">Wednesday</label>
						<form:checkbox path="wednesday" />
					</div>
					<label for="days">Thursday</label>
					<form:checkbox path="thursday" />
					<div class="form-group">
					<label for="days">Friday</label>
						<form:checkbox path="friday" />
					</div>
					<label for="days">Saturday</label>
					<form:checkbox path="saturday" />
					<div class="form-group">
					<label for="days">Sunday</label>
						<form:checkbox path="sunday" />
					</div>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form:form>
			</div>
		</div>
	</div>

	<script src="content/js/jquery.min.js"></script>
	<script src="content/js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function() {
			$('.dropdown-toggle').dropdown();
		});
	</script>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>

</body>
</html>