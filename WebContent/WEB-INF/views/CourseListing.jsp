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
	<script src="<c:url value="/resources/scripts/courses.js" />"></script>
	<title>Course Listing</title>
</head>
<body>
	<div id="wrap">
	   <h1>Paymentus Web App : Paul Hayman</h1>
	   
	   <ul id="nav">
	      <li><a href="">Home</a></li>
	      <li><a href="<c:url value="/StudentListing"/>">Students</a></li>
	      <li><a href="<c:url value="/CourseListing"/>">Courses</a></li>
	      <li><a href="<c:url value="/TreeProcessor"/>">Q2: Tree Processing</a></li>
	   </ul>
	   
	   <div id="content">
	      <p>Click "View Students" for a course to view in right pane all students enrolled in course.</p>
 		</div>
		<div class = "container">
			<h3>Courses</h3>
			<div class = "listingDetails left">
				<input type="button" value="Add Course" onclick="location.href='<c:url value="/AddCourse"/>'"/>	
				<table id = "courses">
				<thead>
					<tr>
						<th>Course Title</th><th>Course Code</th>
					</tr>
				</thead>
				<c:forEach items="${courseListing}" var="course">
				<form:form method="POST" action="CourseInfo" modelAttribute="courseInfo">
					<tr>
						<td><form:input type ="hidden" path="courseTitle" value="${course.courseTitle}"/><c:out value="${course.courseTitle}"/></td>
						<td><form:input type ="hidden" path="courseCode" value="${course.courseCode}"/><c:out value="${course.courseCode}" /></td>
						<td class="editbutton">
							<form:input type ="hidden" path="id" value="${course.id}"/>
							<input  type="submit" value="Edit Course"/>
							<input type="button" value="View Students" onclick="getStudentsInCourse(${course.id});"/>
						</td>
					</tr>
					</form:form>
				</c:forEach>
				</table>
			</div>
			<div class = "listingDetails right">
				<table id = "studentsInCourse">
					<thead>
						<tr>
							<th>StudentID</th><th>First Name</th><th>Last Name</th>
						</tr>
					</thead>
					<tbody></tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>