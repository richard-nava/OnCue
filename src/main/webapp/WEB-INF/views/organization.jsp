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

	<div class="container">
		<h3>${org.orgName} Manager Page</h3>
		<h4>${msg}</h4>
	</div>
	
	<div class="container">
		What would you like to do? 
		<br>
  		<div class="btn-group" role="group">
		    <button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		      Classes
		    </button>
		    <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
		    <c:forEach var="var" items="${classes}">
		      <a class="dropdown-item" id="${var.class_id}" href="class-page?id=${var.class_id}">${var.class_name}</a>
		      <!-- organization?id=${org.id} -->
      		</c:forEach>
      		    <div class="dropdown-divider"></div>
      		<a class="dropdown-item" href="add-class" role="button">New Class</a>
      		
   			 </div>
  		</div>
  		 <div class="btn-group" role="group">
  		
  		<button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		      Students
		    </button>
		    <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
		    <a class="dropdown-item" href="view-students" role="button">View All</a>
      		<a class="dropdown-item" href="add-student" role="button">Add Student</a>
    
   			 </div>
   			 </div>
  		<a class="btn btn-primary disabled" href="memberships" role="button">Memberships</a>	
  		<a class="btn btn-primary" href="organization-settings" role="button">${org.orgName} Settings</a>
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