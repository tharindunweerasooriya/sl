<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.m_user"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/user.js"></script>
</head>
<body>
<div class="container"><div class="row"><div class="col-6"> 
		<h1></h1><br>
		<div id="divItemsGrid">

<br>
</div>
</div></div></div>
<table align = "center" border="0px" cellspacing="100px" cellpadding="60px">
<%



try{

Class.forName("com.mysql.jdbc.Driver");

Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/slt", "root", ""); 



String query = "SELECT * FROM m_user";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(query);
int i =0;
// iterate through the rows in the result set
while (rs.next())
{


String mEMP_NO = Integer.toString(rs.getInt("mEMP_NO"));
String mEMP_NAME = rs.getString("mEMP_NAME");
String RTOM = rs.getString("RTOM");


if(i==3){


out.print("<tr></tr>");

}

i++;


%>



<th >
<div class="card" style="width: 18rem;">
<div class="card-body">
<h4 class="card-title">Employee Name :<%=mEMP_NAME %></h4><br><br>
<h5class="card-text"> Employee No:<%= mEMP_NO %></h5> <br><br>
<h5class="card-text"> RTOM:<%= RTOM %></h5> <br><br>
<a class="btn btn-danger" href="admin.jsp?mEMP_NO=<%=mEMP_NO %>&mEMP_NAME=<%=mEMP_NAME %>&RTOM=<%=RTOM %>">Assign</a>
</div>
</div>
</th>

<%




}

}catch(Exception e){

out.println(e);


}



%>
</table>


</body>
</html>