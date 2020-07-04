<%@page import="java.util.List"%>
<%@page import="com.tcs.Models.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%--     <%@ include file="/JSP/Expirepage.jsp" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retail Banking System</title>
<style>
div.container {
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
     margin-left:200px; 
    
      border-left: 2px solid gray; 
    padding: 5em;
    overflow: hidden;  
}

article h1{
	/*Do styling inside the article elements*/
	
}


table#view  { 
      border-collapse: collapse; 
      width: 70%;
      margin-left:100px;
   
}
 
th { 
    background-color: grey;
    color: white;
    height:30px;
}


table#view , th, #view td {
    border: 1px solid black;
}
</style>

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

<h3 style="text-align:center">ACCOUNT DETAILS</h3>

 <% 
 
List<Account> list=(List<Account>)request.getAttribute("list");
 
 String msg=(String)request.getAttribute("message");
 String id=(String)request.getAttribute("id");
%> 

<% if(msg!=null){ %>

<h4 style="color:red"><%=msg %></h4>
<%} %>



<table  border="1" id="view">
<tr>
        <th style="column-width:120px">Account ID</th>
        <th style="column-width:150px">Customer ID</th>
        <th style="column-width:120px">Customer Type</th>
        <th style="column-width:80px">Balance</th>
        <th>Action</th>
      
</tr>

<% for(Account acc:list)
	{
	%>
<tr>
<td><%=acc.getAccountid() %></td>
<td> <%=acc.getCustid()%> </td> 
<td> <%=acc.getAccounttype() %> </td>
<td><%=acc.getDeposit() %></td>
<td><a href="<%=request.getContextPath()%>/servletcontrol?action=deleteAccount&accid=<%=acc.getAccountid()%>">Delete</a></td>
</tr>

<%} %>

</table>
</article>

<footer>Copyright & Retail Banking.com</footer>

</div>
</body>
</html>