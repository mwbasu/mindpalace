<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Login</title>
</head>
<body>
<div class="container">
<h1>EMPLOYEE LOGIN</h1>

<center><form action="elogin" method="post" class="login">
	EMAIL <input type="text" name="email"/><br/>
	PASSWORD <input type="password" name="pass"><br/>
	<input type="submit" value="LOGIN"> 
	 
</form></center>
</div>
<style type="text/css">
body{
font-family:sans-serif;
font-weight:300;
background-color:orange;
}
.container{
max-width:600px;
margin:0 300px;
padding:80px 0;
text-align:center;
margin-top:0.03%;
background-color:black;
}
.login{
color:yellow;
padding:20px 0px;
position:relative;
}
.login input[type="text"],
.login input[type="password"] {
  width: 100%;
  max-width:400px;
  height:30px;
  font-family: 'Ubuntu', sans-serif;
  margin:10px 0;
  border-radius:5px;
  border:3px solid black;
  outline:black;
  padding-left:10px;
}
.login input[type="submit"]

{
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
color:yellow;
font-weight:300;
}
h1 {
	margin-top:10%;
   text-shadow: 0px 5px 15px #000;
   color:yellow;
    font-size:30px;
   text-align: center;
}
</style>
</body>
</html>