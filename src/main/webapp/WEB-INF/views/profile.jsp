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
<title>${loggedInUser.firstName}'s Profile</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	
	<br><br>
	
	<div class="container">
		<h2>Welcome, ${loggedInUser.firstName}!</h2>
	</div>
	
	<br><br>
	
	<div class="container">
		<h3>What would you like to do?</h3>
		<br>
		<div class="btn-group" role="group">
		    <button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		      Your Organizations
		    </button>
		    <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
		    <c:forEach var="org1" items="${orgs}">
		      <a class="dropdown-item" id="${org1.id}" href="organization?id=${org1.id}"> ${org1.orgName}</a>
		      <!-- organization?id=${org.id} -->
      		</c:forEach>
   			 </div>
  		</div>
  		<a class="btn btn-primary" href="new-organization" role="button">New Organization</a>
  		<a class="btn btn-primary" href="profile-settings" role="button">Settings</a>
  		
		
	</div>
	

	
	


<!-- JS Scripts -->
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