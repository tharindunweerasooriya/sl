<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.details"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Msan Details</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/user.js"></script>

</head>
<body>
<h1 align="center">MSAN Details</h1><br>

<h2>Search List</h2>
<p>Type something in the input field to search the list for specific items:</p>  
<input id="myInput" type="text" placeholder="Search..">
<br><br>
<div id="divItemsGrid">
		
 <%
 details itemObj = new details(); 
 out.print(itemObj.readDetails());
 %>
<br>

</div>
</body>
</html>