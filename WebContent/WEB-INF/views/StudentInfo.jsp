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
	<div id="wrap">
	   <h1>Paymentus Web App : Paul Hayman</h1>
	   
	   <ul id="nav">
	      <li><a href="#">Home</a></li>
	      <li><a href="<c:url value="/StudentListing"/>">Students</a></li>
	      <li><a href="<c:url value="/CourseListing"/>">Courses</a></li>
	      <li><a href="<c:url value="/TreeProcessor"/>">Q2: Tree Processing</a></li>
	   </ul>
	   
	   <div id="content">
 		</div>
	
		<div class = "container">
			<h3>Student Info</h3>
			<form:form method="POST" action="UpdateStudent" modelAttribute="student">
	             <table>
	                <tr>
	                    <td><form:label path="firstName">First Name</form:label></td>
	                    <td><form:input path="firstName" value="${student.firstName }"/></td>
	                </tr>
	                <tr>
	                    <td><form:label path="lastName">Last Name</form:label></td>
	                    <td><form:input path="lastName" value="${student.lastName }"/></td>
	                </tr>
	                <tr>
	               		<td><form:input type ="hidden" path="id" value="${student.id }"/></td>
	                    <td class="editbutton"><input type="submit" name="update" value="Update Info"/>
	                     	<input type="submit" name="delete" value="Delete"/></td>
	                </tr>
	            </table>
	        </form:form>
			<div class = "listingDetails left">
				<table id = "coursesForStudents">
					<h3>Courses For Student</h3>
					<thead>
						<tr>
							<th>Course Title</th><th>Course Code</th>
						</tr>
					</thead>
					<c:forEach items="${coursesForStudent}" var="course">
						<tr>
							<td><c:out value="${course.courseTitle}"/></td>
							<td><c:out value="${course.courseCode}" /></td>
							<td>					
				           		<input type="button" value="Withdraw Course" onclick="withdrawFromCourse('${student.id}','${course.id }');"/>				      
				       		 </td>	
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class = "listingDetails right">
				<h3>Available Courses </h3>
				<table id = "allCourses">
					<thead>
						<tr>
							<th>Course Title</th><th>Course Code</th>
						</tr>
					</thead>
					<c:forEach items="${allCourses}" var="course">
						<tr>
							<td><c:out value="${course.courseTitle}"/></td>
							<td><c:out value="${course.courseCode}" /></td>
							<td><input type="button" value="Enroll" onclick="enrollStudent('${student.id}','${course.id}');"/></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>		  
	</div>
</body>
</html>