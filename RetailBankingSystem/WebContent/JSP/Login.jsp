<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retail Banking System</title>
<link rel="stylesheet" type="text/css" href="../CSS/Retail.css">

</head>
<body>


<div class="container">
<header><h2>Retail Banking System</h2></header>

<% String message=(String)request.getAttribute("message");

if(message!=null) { %>

<p style="color:red;font-size:20px"><%=message %></p>
<%} %>



<form id="loginformid"action="<%=request.getContextPath() %>/servletcontrol"  method="post">
<table>
<tr>
<td>Username:</td>
<td><input type="text" name="username" required="required"></td>
</tr>
<tr>
<td>Password:</td><td>
<input type="password" name="password" required="required"></td>
</tr>
<tr>
<td>
<button type="submit" name="action" value="bankemployeemanagement">Login</button></td>
<td><button type="reset">Cancel</button></td></tr>
</table>
</form>

<footer>Copyright @ Retail Banking.com</footer>

</div>
</body>
</html>