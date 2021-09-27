<%@page import="com.user"%>
<%@page import="com.m_user"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MSAN Request</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/user.js"></script>


</head>
	<body>
	
		<div class="container"><div class="row"><div class="col-6"> 
		<h1 align="center">MSAN Management</h1><br>
		<h2>Search List</h2>
<p>Type something in the input field to search the list for specific items:</p>  
<input id="myInput" type="text" placeholder="Search..">
<br><br>
		<div id="divItemsGrid">

 <%
 user itemObj = new user(); 
 out.print(itemObj.readAdmin());
 %>
<br>

</div>
	
 <form id="formItem" name="formItem">
 		
<br>Assign To : 
 		<input id="ASSIGN_TO" name="ASSIGN_TO" type="text" 
 		class="form-control form-control-sm"><br>
 		
 		
 <input id="btnSaveA" name="btnSaveA" type="button" value="Save" 
 class="btn btn-primary">
 <input type="hidden" id="hidItemIDSaveA" 
 name="hidItemIDSaveA" value="">
 
 <a type="button" href="msan_details.jsp" class='btn btn-danger'>View Details</a>		
 
</form>
<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>
<br>

</div> </div> </div>
<h4 align="center">Mobile Users</h4><br>
<div id="divItemsGrid">
<%
 m_user itemObj2 = new m_user(); 
 out.print(itemObj2.readUser());
 %>
 </div>
 
</body>
</html>