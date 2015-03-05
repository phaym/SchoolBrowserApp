<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	      <li><a href="#">Home</a></li>
	      <li><a href="<c:url value="/StudentListing"/>">Students</a></li>
	      <li><a href="<c:url value="/CourseListing"/>">Courses</a></li>
	      <li><a href="<c:url value="/TreeProcessor"/>">Q2: Tree Processing</a></li>
	   </ul>
	   
	   <div id="content">
	      <p>Click "View Students" for a course to view in right pane all students enrolled in course.</p>
 		</div>
		<div class = "container">
			<div class = "listingDetails left">
				<input type="button" value="Add Course" onclick="location.href='<c:url value="/AddCourse"/>'"/>	
				<table id = "courses">
				<thead>
					<tr>
						<th>Course Title</th><th>Course Code</th>
					</tr>
				</thead>
				<c:forEach items="${courseListing}" var="course">
					<tr>
						<td><c:out value="${course.courseTitle}"/></td>
						<td><c:out value="${course.courseCode}" /></td>
						<td>
							<input type="button" value="View Students" onclick="getStudentsInCourse(${course.id});"/>
						</td>
					</tr>
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