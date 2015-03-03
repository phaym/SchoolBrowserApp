<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="<c:url value='resources/styles/main.css'/>"  rel="stylesheet">
	<script src="<c:url value="/resources/scripts/jquery-1.11.2.min.js" />"></script>
	<script src="<c:url value="/resources/scripts/students.js" />"></script>
	<title>Student Listing</title>
</head>
<body>
	<h3>Student Listing</h3>
	<div class = "container">
		<div class = "listingDetails left">
			<table id = "students">
				<tr>
					<th>StudentID</th><th>First Name</th><th>Last Name</th>
				</tr>
				<c:forEach items="${studentListing}" var="student">
					<tr>
						<td><c:out value="${student.id}"/></td>
						<td><c:out value="${student.firstName}"/></td>
						<td><c:out value="${student.lastName}"/></td>
						<td>					
				           <input type="button" value="View Courses" onclick="getCoursesForStudent(${student.id });"/>				      
				        </td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class = "listingDetails right">
			<table id = "coursesForStudents">
			<thead>
				<tr>
					<th>Course Title</th><th>Course Code</th>
				</tr>
			</thead>
			<tbody></tbody>
			</table>
		</div>
	</div>
</body>
</html>