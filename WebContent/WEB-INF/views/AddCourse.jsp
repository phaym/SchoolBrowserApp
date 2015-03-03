<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Course</title>
</head>
<body>
	<h3>Add New Course</h3>
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
</body>
</html>