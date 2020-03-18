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

<title>Add Student</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<br><br>

	<div class="container">
	<div class="card center">
			<div class="card-body">
					<div>
						<h2>Add student to ${org.orgName}</h2>						
					</div>
				${error}
				<form:form action="addstudent" modelAttribute="student" method="post">
				    <form:input type="hidden" path="id"/>
					<div class="form-group">
				   	 <label for="firstName">First Name</label>
				  	  <form:input type="text" path="firstName" class="form-control" id="firstName" aria-describedby="emailHelp"/>  
				    </div>
				    <div class="form-group">
				   	 <label for="lastName">Last Name</label>
				  	  <form:input type="text" path="lastName" class="form-control" id="lastName" aria-describedby="emailHelp"/>  
				    </div>
				    <div class="form-group">
				   	 <label for="email">Email Address</label>
				  	  <form:input type="text" path="email" class="form-control" id="email" aria-describedby="emailHelp"/>  
				    </div>
				    <div class="form-group">
				   	 <label for="pin">Create Sign-In Pin</label>
				  	  <form:input type="text" path="pin" class="form-control" id="pin" aria-describedby="emailHelp"/>  
				   	  <small id="pinHelp" class="form-text text-muted">Only numbers!</small>
				    </div>
				    	 <label for="classes">Add to class:</label>
					    <c:forEach var="c" items="${classes}">
					    	<form:checkbox path="classesAssociated" value="${c.class_id}"/>${c.class_name}
					    </c:forEach>
				  <button type="submit" class="btn btn-primary">Submit</button>
				</form:form>
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
</body>
</html>