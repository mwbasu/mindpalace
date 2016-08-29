<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="org.appr.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.*" %>
    <%@ page import="org.appr.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
   <h1>EMPLOYEE LIST</h1><br/><br/>	
   
<%
	Object obj=request.getAttribute("FLIST");
	ArrayList<Employee> e2=(ArrayList<Employee>)obj;
		ArrayList<Employee> flist=(ArrayList<Employee>)request.getAttribute("FLIST");
	Employee e3=flist.get(0);
	%>
	
	<center><table border="1">
	<tr><th>EMPLOYEE ID</th><th>EMPLOYEE NAME</th></tr>
	<% 
		for(Employee p:e2){
	%>
	<CENTER><tr><td><%=p.getEid() %></td>
		<td><%=p.getName() %></td>
		<td></td>
		</tr></CENTER>
		
	<%
	}
	%>
	</table>
	</center>
	
	<style type="text/css">
	body{
	background-color:silver;
	}
	.container{
	max-width:600px;
margin:0 300px;
padding:80px 0;
text-align:center;
margin-top:0.03%;
background-color:orange;
	}
	.save{
	
outline:white;
border:3px solid black;
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
.f{
color:black;
}
	
	</style>
	<form action="FormServlet" method="post" class="f">
	ENTER EMPLOYEE_ID
			<input type="text" name="h1" value="<%=e3.getEid() %>">	
			<br/><br/>
	<input type="hidden" name="h2" value="<%=e3.getName() %>">
		<input type="submit" value="SAVE" class="save">
	</form>
	</div>
</body>
</html>