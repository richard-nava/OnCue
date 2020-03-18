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

<title>${thisclass.class_name}</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<br>
	<div class="container">
		<h3>${thisclass.class_name} Class Page</h3>
		<br>
		<h5>Description:</h5>
		<h6>${thisclass.description}</h6>
	</div>
	<br><br><br>
	<div class="container">
		<h4>Roster:</h4>
		<c:forEach var="stud" items="${thisclass.students}">
		<p>${stud.toString()}
		</c:forEach>
	</div>
	


</body>
</html>