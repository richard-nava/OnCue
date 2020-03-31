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
<title>${org.orgName} Settings</title>
<link rel="stylesheet" href="static/styles.css" type="text/css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
	<!-- HEADER -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- END HEADER -->
	<div class="container">
		<h3>${org.orgName}Settings</h3>
		<div class="row stud-details">

			<div class="card col-sm">
				<div class="card-body ">
					<div>
						<h2>Details</h2>
					</div>
					${error}
					<form:form action="updateOrgDetails" modelAttribute="updatedOrg"
						method="post">
						<div class="form-group">
							<form:input type="hidden" path="id" value="${org.id}" />
							<label for="exampleFname">Name</label>
							<form:input type="text" path="orgName" class="form-control"
								id="exampleFname" aria-describedby="emailHelp"
								value="${org.orgName}" />
						</div>
						<div class="form-group">
							<label for="exampleInputLname">Description</label>
							<form:input type="text" path="description" class="form-control"
								id="exampleLname" aria-describedby="emailHelp"
								value="${org.description}" />
						</div>
						<button type="submit" class="btn btn-primary">Edit
							${org.orgName}'s Details</button>
					</form:form>
				</div>
			</div>

			<div class="card col-sm ">
				<div class="card-body">
					<div>
						<h2>Address</h2>



					</div>
					${error}
					<form:form action="editOrgAddress" modelAttribute="orgAddress"
						method="post">
						<div class="form-group">
							<form:input type="hidden" path="address_id"
								value="${org.address.address_id}" />
							<label for="exampleFname">Street</label>
							<form:input type="text" path="street" class="form-control"
								id="exampleFname" aria-describedby="emailHelp"
								value="${org.address.street}" />
						</div>
						<div class="form-group">
							<label for="exampleInputLname">City</label>
							<form:input type="text" path="city" class="form-control"
								id="exampleLname" aria-describedby="emailHelp"
								value="${org.address.city}" />
						</div>
						<div class="form-group">
							<label for="examplePin">State</label>
							<form:input type="text" path="state" class="form-control"
								id="pin" aria-describedby="emailHelp"
								value="${org.address.state}" />
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Zip</label>
							<form:input type="number" path="zip" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								value="${org.address.zip}" />
						</div>
						<button type="submit" class="btn btn-primary">Change
							${org.orgName}'s Address</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Class</th>
					<th scope="col">Student Count</th>
					
					
				</tr>
			</thead>
			<c:forEach var="i" items="${classesOffered}">
			<tr>
				<td>${classesOffered.indexOf(i)+1}</td>
				<td><a id="${i.class_id}"
								href="class-page?id=${i.class_id}">${i.class_name}</a>
				</td>
				<td>
					${i.students.size()}
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>


	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>