<%@page import="org.appr.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome HR</title>
</head>
<body>
<div class="container">
<h1> WELCOME HR </h1>
<%
	String s=request.getParameter("name");
	Employee e=(Employee)request.getAttribute("emp");
	%>	
	
	<h3> Logged Name : <%=e.getName() %></h3><br/>
	<h3> Logged Id : <%=e.getEid() %></h3><br/>
<form action="showscore" method="post">
<center>
<input type="text" name="id" value="<%=e.getEid() %>"><br/><br/></center>
<input type="submit" value="GENERATE SCORE" class="sub" />
<style type="text/css">
body{
background-color: aqua;
}
.sub{
outline:black;
border:3px solid black;
background-color:rgba(255,255,255,0.2);
width:250px;
border-radius:3px;
margin:10px auto 20px auto;
padding:10px 15px;
display:block;
text-align:center;
font-size:18px;
color:black;
font-weight:300;
}
.container{
max-width:600px;
margin:0 300px;
padding:80px 0;
text-align:center;
margin-top:0.03%;
}
</style>
</div>
</body>
</html>