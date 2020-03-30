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

<title>${stud.firstName}'s Profile</title>
</head>
<body>

<!-- HEADER -->
<jsp:include page="header.jsp"></jsp:include>
<!-- END HEADER -->

<div class="container">
	<h2>${stud.firstName}'s Profile</h2>
		<div class="row">
			<div class="card col-sm">
				<div class="card-body ">
					<div>
						<h2>Details</h2>



					</div>
					${error}
					<form:form action="editStud" modelAttribute="student" method="post">
						<div class="form-group">
							<form:input type="hidden" path="id" value="${stud.id}" />
							<label for="exampleFname">First Name</label>
							<form:input type="text" path="firstName" class="form-control"
								id="exampleFname" aria-describedby="emailHelp"
								value="${stud.firstName}" />
						</div>
						<div class="form-group">
							<label for="exampleInputLname">Last Name</label>
							<form:input type="text" path="lastName" class="form-control"
								id="exampleLname" aria-describedby="emailHelp"
								value="${stud.lastName}" />
						</div>
						<div class="form-group">
							<label for="examplePin">Pin</label>
							<form:input type="number" path="pin" class="form-control"
								id="pin" aria-describedby="emailHelp" value="${stud.pin}" />
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Email address</label>
							<form:input type="email" path="email" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								value="${stud.email}" />
						</div>
						<button type="submit" class="btn btn-primary">Change
							${stud.firstName}'s Details</button>
					</form:form>
				</div>
			</div>

			<div class="card col-sm ">
				<div class="card-body">
					<div>
						<h2>Address</h2>



					</div>
					${error}
					<form:form action="editStudAddress" modelAttribute="address"
						method="post">
						<div class="form-group">
							<form:input type="hidden" path="address_id"
								value="${stud.address.address_id}" />
							<label for="exampleFname">Street</label>
							<form:input type="text" path="street" class="form-control"
								id="exampleFname" aria-describedby="emailHelp"
								value="${stud.address.street}" />
						</div>
						<div class="form-group">
							<label for="exampleInputLname">City</label>
							<form:input type="text" path="city" class="form-control"
								id="exampleLname" aria-describedby="emailHelp"
								value="${stud.address.city}" />
						</div>
						<div class="form-group">
							<label for="examplePin">State</label>
							<form:input type="text" path="state" class="form-control"
								id="pin" aria-describedby="emailHelp"
								value="${stud.address.state}" />
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Zip</label>
							<form:input type="number" path="zip" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								value="${stud.address.zip}" />
						</div>
						<button type="submit" class="btn btn-primary">Change
							${stud.firstName}'s Address</button>
					</form:form>
				</div>
			</div>

			<div class="container">
				<div class="sign-ins">
					<h4>Sign-In's</h4>

					<table class="table table-bordered">
						<tr class="text-success">
							<th>Date</th>
							<th>Time</th>
							<th>Class</th>
						</tr>
						<tbody>
						<tr>
							<c:forEach var="i" items="${times}">
								
									<%-- <javatime:parseLocalDateTime value="${i.timestamp}" pattern="MM-dd-yyyy" var="parsedDate" /> --%>
									<td>${i.day}</td>
									<td>${i.time}</td>
									<td>${i.classAssoc.classTaken.class_name}</td>
								
							</c:forEach>
							
							</tr>
						</tbody>
					</table>
				</div>

				<div class="container">
					<a class="btn btn-danger" href="deleteStudent" role="button">Delete
						${stud.firstName}</a>
					<a class="btn btn-primary" href="addToClass" role="button">Add
						${stud.firstName} to Class</a>
				</div>
			</div>
		</div>
	</div>




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
<script src="static/js/calendar.js"></script>

</body>
</html>