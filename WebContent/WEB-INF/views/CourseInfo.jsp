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
			<h3>Course Info</h3>
			<form:form method="POST" action="UpdateCourse" modelAttribute="course">
	             <table>
	                <tr>
	                    <td><form:label path="courseTitle">Course Title</form:label></td>
	                    <td><form:input path="courseTitle" value="${course.courseTitle}"/></td>
	                </tr>
	                <tr>
	                    <td><form:label path="courseCode">Course Code</form:label></td>
	                    <td><form:input path="courseCode" value="${course.courseCode }"/></td>
	                </tr>
	                <tr>
	               		<td><form:input type ="hidden" path="id" value="${course.id }"/></td>
	                    <td class="editbuttons">
	                    	<input type="submit" name="update" value="Update Course"/>
	                     	<input type="submit" name="delete" value="Delete"/></td>
	                </tr>
	            </table>
	        </form:form>
	        <div class = "listingDetails left"></div>
			<div class = "listingDetails right">
				<h3>Students in Selected Course</h3>
				<table id = "students">
					<tr>
						<th>StudentID</th><th>First Name</th><th>Last Name</th>
					</tr>
					
					<c:forEach items="${studentsInCourse}" var="student">
						<tr>
							<td><c:out value="${student.id}"/></td>
							<td><c:out value="${student.firstName}"/></td>
							<td><c:out value="${student.lastName}"/></td>							      
						</tr>	
					</c:forEach>
				</table>
			</div>
		</div>		  
	</div>
</body>
</html>