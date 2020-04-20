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

<title>Multiple Sign in</title>
</head>
<body class="signin-body">

<div class="container signin-card-main">
		<div class="card shadow-lg p-3 mb-5 center" style="width: 20rem;">
		  <img class="card-img-top orgsignin-img center"
					src="static/img/org/${org.id}/profile/${org.image}"
					alt="Card image cap">
		  <div class="card-body">
		    <h5 class="card-title">Welcome to ${org.orgName}</h5>
		    <h6>${msg} ${error}</h6>
		    	<form:form action="orgSignInMulti" modelAttribute="student" method="post">
					<div class="form-group">
					<form:input path="pin" value="${stud.pin}"/>
				   	 <c:forEach var="i" items="${classesAvailable})">
				   	 <label for="pin">Choose Class:</label>
				  	 <form:checkbox path="class" class="form-control" id="${i.class_id}" aria-describedby="emailHelp"/>${i.class_name} 
				    </c:forEach>
				    </div>
				  <form:button type="submit" class="btn btn-primary">Sign In</form:button>
				</form:form>
		  </div>
		</div>
	</div>

<jsp:include page="footer.jsp"/>


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