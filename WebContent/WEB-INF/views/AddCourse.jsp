<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="<c:url value='resources/styles/main.css'/>"  rel="stylesheet">
	<title>Add New Course</title>
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
	      <p>Fill in new course info.</p>
 		</div>
 		<div class = "container">
		 	<form:form method="POST" action="AddCourse" modelAttribute="course">
	             <table>
	                <tr>
	                    <td><form:label path="courseTitle">Course Title</form:label></td>
	                    <td><form:input path="courseTitle"/></td>
	                </tr>
	                <tr>
	                    <td><form:label path="courseCode">Course Code</form:label></td>
	                    <td><form:input path="courseCode"/></td>
	                </tr>
	                <tr>
	                    <td><input type="submit" value="Submit"/></td>
	                </tr>
	            </table>
	        </form:form>
	     </div>
	 </div>
</body>
</html>