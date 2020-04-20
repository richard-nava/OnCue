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
		<div class="container">
			<div class="card org-card mb-3">
				<img class="card-img-top org-img center"
					src="static/img/org/${org.id}/profile/${org.image}"
					alt="Card image cap">
				<div class="card-body text-center">
					<h4 class="card-title">${thisclass.class_name}</h4>
					<p class="card-text text center">
					<h5>Description:</h5>
		<h6>${thisclass.description}</h6>
						<small class="text-muted"></small>
					</p>
				</div>
			</div>
			
		</div>
	
		
		
	</div>
	<br>
	<br>
	<div class="container">
		<h4>Days Available</h4>
		<table class="table table-bordered">
			<tr class="text-success">
				<th>Monday</th>
				<th>Tuesday</th>
				<th>Wednesday</th>
				<th>Thursday</th>
				<th>Friday</th>
				<th>Saturday</th>
				<th>Sunday</th>
				
			</tr>
			<tbody>
				<tr>
					<td>
					<c:if test="${thisclass.monday == true}">
						<img src="https://img.icons8.com/metro/26/000000/checkmark.png"/>
					</c:if>
					</td>
					<td>
					<c:if test="${thisclass.tuesday == true}">
						<img src="https://img.icons8.com/metro/26/000000/checkmark.png"/>
					</c:if>
					</td>
					<td>
					<c:if test="${thisclass.wednesday == true}">
						<img src="https://img.icons8.com/metro/26/000000/checkmark.png"/>
					</c:if>
					</td>
					<td>
					<c:if test="${thisclass.thursday == true}">
						<img src="https://img.icons8.com/metro/26/000000/checkmark.png"/>
					</c:if>
					</td>
					<td>
					<c:if test="${thisclass.friday == true}">
						<img src="https://img.icons8.com/metro/26/000000/checkmark.png"/>
					</c:if>
					</td>
					<td>
					<c:if test="${thisclass.saturday == true}">
						<img src="https://img.icons8.com/metro/26/000000/checkmark.png"/>
					</c:if>
					</td>
					<td>
					<c:if test="${thisclass.sunday == true}">
						<img src="https://img.icons8.com/metro/26/000000/checkmark.png"/>
					</c:if>
					</td>

				</tr>
			</tbody>
		</table>

	</div>
	<br><br>
	<div class="container">
		<h4>Class Roster:</h4>
		
		<table class="table table-bordered">
						<tr class="text-success">
							<th>#</th>
							<th>Name</th>
							<th>Pin</th>
							<th>Email</th>
							<th>Classes</th>
						</tr>
						<tbody>
		<c:forEach var="i" items="${thisclass.students}">
			<tr>
				<td>${students.indexOf(i)+1}</td>
				<td><a href="student-file?id=${i.id}">${i.firstName} ${i.lastName}</a>
				</td>
				<td>${i.pin}</td>
				<td>${i.email}</td>
				<td>
				<c:forEach var="j" items="${i.classesAssociated}">
					${j.class_name}
				</c:forEach>
				</td>
			</tr>
		</c:forEach>
		</tbody>
		</table>
	</div>
	


</body>
</html>