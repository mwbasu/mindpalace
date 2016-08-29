<%@page import="org.appr.Feedback"%>
<%@page import="org.appr.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*,javax.servlet.*,javax.servlet.http.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager Employee Rating</title>
</head>
<body>
	<%
	String str="x";
	//String s=request.getParameter("name");		//retrive value from html
	Employee e=(Employee)request.getAttribute("emp");	//receives value from setattrib of EmpLogin
	//request.setAttribute("emp", e);
	//RequestDispatcher rd=request.getRequestDispatcher("EmpFeedbackServlet.java");
	//rd.forward(request, response);
	int i=0;
	%>	
	<div class="container">
	<center>Employee Name:<%=e.getName() %><br/><br/></center>	
	<form action="MngrFeedbackServlet" method="get">
	<input type="hidden" name="id" value=<%=e.getEid() %>>
	<%
		Object obj=request.getAttribute("flist");		//receiving object from first
		ArrayList<Feedback> fdlist=(ArrayList<Feedback>)obj;
		for(Feedback p:fdlist){
			if(!str.equals(p.getQtype())){
				str=p.getQtype();
	%>			Question Type : <%=p.getQtype()%><br/><%
			}
		%>
		<center><table border="1" class="fd"><tr><th> Previous Score </th></tr><tr><td><%=p.getSelf_f() %> </td></tr>
		Que No.<%=(i+1) %> <%=p.getQtext()%><br/>
		<input type="hidden" name="qid<%=i%>" value=<%=p.getQid() %>>
			<select name="feedback_rating<%=i%>">
			<option value="0">N.A</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			</select><br/>
			
		</table>
		</center>
		<%
		i+=1;
		//String val[]=request.getParameterValues("feedback_rating");
		} 
		%>
		</div>
		<input type="hidden" name="c" value="<%=i%>">
		<input type="submit" value="SAVE" class="save"/>
		
		</form>
		
		<style type="text/css">
		.container{
		text-align:center;
		}
		body{
		background-color:lime;
		}
		.save{
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
		</style>
			
</body>
</html>