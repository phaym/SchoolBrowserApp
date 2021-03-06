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
	      <li><a href="">Home</a></li>
	      <li><a href="<c:url value="/StudentListing"/>">Students</a></li>
	      <li><a href="<c:url value="/CourseListing"/>">Courses</a></li>
	      <li><a href="<c:url value="/TreeProcessor"/>">Q2: Tree Processing</a></li>
	   </ul>
	   
	   <div id="content">
	   <p>Click "View Courses" for a student to view in right pane courses student is enrolled.</p>
 		</div>
	
		<div class = "container">
			<div class = "listingDetails left">
				<h3>Students</h3>
				<input type="button" value="Add Student" onclick="location.href='<c:url value="/AddStudent"/>'"/>		
				<table id = "students">
					<tr>
						<th>StudentID</th><th>First Name</th><th>Last Name</th>
					</tr>
					
					<c:forEach items="${studentListing}" var="student">
						<form:form method="POST" action="StudentInfo" modelAttribute="infoStudent">
						<tr>
							<td><form:input type ="hidden" path="id" value="${student.id }"/><c:out value="${student.id}"/></td>
							<td><form:input type ="hidden" path="firstName" value="${student.firstName }"/><c:out value="${student.firstName}"/></td>
							<td><form:input type ="hidden" path="lastName" value="${student.lastName }"/><c:out value="${student.lastName}"/></td>					
					        <td class="editbutton">
					        	<input  type="submit" value="Edit Student"/>					
				           		<input type="button" value="View Courses" onclick="getCoursesForStudent(${student.id});"/>				      
				       		 </td>			      
						</tr>	
						</form:form>
					</c:forEach>
				</table>
			</div>
			<div class = "listingDetails right">
				<h3>Courses for Selected Student</h3>
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
	</div>
</body>
</html>