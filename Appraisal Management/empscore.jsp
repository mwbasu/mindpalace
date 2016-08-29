<%@page import="org.appr.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Final Results</title>
</head>
<body>
<%
	Object obj=request.getAttribute("score");
	ArrayList<Employee> fdlist=(ArrayList<Employee>)obj;
	for(Employee e:fdlist){
%>
<center><table border='1'>
<strong><tr><th>Name</th><th>Score(%)</th></tr></strong>
<tr><td><%=e.getName() %></td><center><td><%=e.getMan_r() %>%</td></center><br/><br/>
</table>
	</center>		
<%	}
%>
<center><FORM action="home.jsp" >
 <input type="submit" value="LOG OUT" class="bu" /></center>
<style type="text/css">
body{
background-color:black;
color:yellow;
}
.bu{
outline:black;
border:3px solid white;
background-color:rgba(255,255,255,0.2);
width:250px;
border-radius:3px;
margin:10px auto 20px auto;
padding:10px 15px;
display:block;
text-align:center;
font-size:18px;
color:white;
font-weight:300;
}

</style>
</body>
</html>