<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="<c:url value='resources/styles/main.css'/>"  rel="stylesheet">
	<script src="<c:url value="/resources/scripts/jquery-1.11.2.min.js" />"></script>
	<script src="<c:url value="/resources/scripts/tree.js" />"></script>
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
	      Value To Check
	      <ul>
			 <li>Input should be a single integer value.</li>
		</ul>
		 Tree
			<ul>
				<li>Input should be a comma-delimited string that represents tree node values in a binary tree.</li> 
				<li>Input should be in a breadth-first, left-to-right format.</li>
				<li>Example input: 4,5,9,8,6,,5,2,7,,,,8</li>
			</ul
 		</div>
 		<br>
		<table id="treeForm">
			<tr>
				<td>Tree String</td><td><input id="treeString"></input></td>
			</tr>
			<tr>
				<td>Value To Check</td><td><input id="valueToCheck"></input></td>
			</tr>
			<tr>
				<td>Levels:</td><td><span id="resultField"></span></td>
			</tr>
			<tr>
				<td><input type="button" value="Submit Input" onclick="processTree();"/></td>
			</tr>
		</table>
	</div>
</body>
</html>