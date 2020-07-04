<%@page import="com.tcs.Models.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%--     <%@ include file="/JSP/Expirepage.jsp" %> --%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retail Banking System</title>
<style>div.container {
    width: 100%;
    border: 1px solid black;
    
}

#homeid
{
	padding-top:50px;
	padding-bottom:100px;
	padding-right:100px;
}
#loginformid
{
	border:1px solid black;
	width:300px;
	height:100px;
	padding-top:25px;
	padding-left:90px;
	margin-top:50px;
	margin-bottom:200px;
	margin-left:450px;
	
}


header, footer {
    padding: 1em;
    color: white;
    background-color:gray;
    clear: left; 
    text-align: center;
    border: 1px solid black;
    
}

#regiesterformid
{
	
	padding-left:300px;
	padding-top:10px;
}

a{
	 text-decoration: none;
}
nav {
    float: left;
    max-width:200px;
    margin: 0;
    padding:1em;
   
}


nav ul { 
    list-style-type: none;
    padding: 0;
}
   

nav ul a {
    text-decoration: none;
}


article {
     margin-left: 180px; 
    
    border-left: 2px solid gray;
    padding: 1em;
    overflow: hidden;  
}

article h1{
	/*Do styling inside the article elements*/
	
}


table#view  { 
      border-collapse: collapse; 
      width: 70%;
   
}
 
th { 
    background-color: grey;
    color: white;
    height:50px;
}


table#view , th, #view td {
    border: 1px solid black;
}</style>
</head>
<body>

<div class="container">

<header><h2>Retail Banking System</h2></header>



<nav>
<ul>
<li><a href="<%=request.getContextPath()%>/servletcontrol?action=Homepage">Home</a></li>
<li ><a href="<%=request.getContextPath()%>/servletcontrol?action=Customerreg">Customer Register</a></li>
<li><a href="<%=request.getContextPath()%>/servletcontrol?action=viewAllCustomerStatus">View ALL Customer Status</a></li>
<li><a href="<%=request.getContextPath()%>/servletcontrol?action=viewAllAccountStatus">View All Account Status</a></li>
<li><a href="<%=request.getContextPath()%>/servletcontrol?action=AllCustomer">AllCustomer</a></li>
<li><a href="<%=request.getContextPath()%>/servletcontrol?action=Logout">Logout</a></li>
</ul>
</nav>
<article>

<% Customer custom=(Customer)session.getAttribute("customer");
String custid=(String)session.getAttribute("custid");
%>

<p style="color:blue;font-size:20px;font-style:italic;">If you want to delete this details permanently,click Delete</p>
<% String msg=(String)request.getAttribute("msg");
if(msg!=null){%>

<p style="color:red;font-size:20px;"><%=msg %></p>
<%} %>


<form action="<%=request.getContextPath()%>/servletcontrol" method="post">
<table>

<tr><td>CustomerId:</td><td><input name="custid" value="<%=custom.getCustid()%>" readonly="readonly"></td></tr>
<tr><td>SSN ID:</td><td><input name="custssnid" value="<%=custom.getCustssnid() %>" readonly="readonly"></td></tr>
<tr><td>Name:</td><td><input readonly="readonly" value="<%=custom.getCustomername()%>"></td></tr>
<tr><td>Age:</td><td><input name="age" readonly="readonly" value="<%=custom.getAge()%>"></td></tr>
<tr><td>AddressLine1:</td><td><input value="<%=custom.getAddressline1()%>" readonly="readonly"></td></tr>
<tr><td>AddressLine2:</td><td><input value="<%=custom.getAddressline2()%>" readonly="readonly"></td></tr>
<tr><td>State:</td><td><input value="<%=custom.getState()%>"readonly="readonly"></td></tr>
<tr><td>City:</td><td><input value="<%=custom.getCity() %>"readonly="readonly"></td></tr>

<tr><td><button type="submit" name="action" value="deleteCustomer" >Delete</button>
<button type="submit" name="action" value="deleteCustomercancel">Cancel</button></td></tr>
</table>
</form>
</article>

<footer>Copyright & Retail Banking.com</footer>

</div>


</body>
</html>