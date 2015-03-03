<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course Listing</title>
</head>
<body>
	<h3>Course Listing</h3>
	<table>
		<c:forEach items="${courseListing}" var="course">
			<tr>
				<td id="${course.id}"><c:out value="${course.courseTitle}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>