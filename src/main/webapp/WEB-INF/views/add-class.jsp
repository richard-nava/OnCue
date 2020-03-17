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
						<h2>Add a Class to ${org.orgName}'s Roster </h2>						
					</div>
				${error}
				<form:form action="create-class" modelAttribute="org" method="post">
				    <form:input type="hidden" path="class_id"/>
					<div class="form-group">
				   	 <label for="class_name">Class Name</label>
				  	  <form:input type="text" path="class_name" class="form-control" id="class_name" aria-describedby="emailHelp"/>  
				    </div>
				    <div class="form-group">
				   	 <label for="description">Description</label>
				  	  <form:input type="text" path="description" class="form-control" id="description" aria-describedby="emailHelp"/>  
				    </div>
				  <button type="submit" class="btn btn-primary">Submit</button>
				</form:form>
			</div>
	</div>
	</div>


</body>
</html>