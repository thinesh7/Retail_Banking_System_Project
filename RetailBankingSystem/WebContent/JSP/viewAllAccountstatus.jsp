
<%@page import="java.util.List"%>
<%@page import="com.tcs.Models.Accountstatus"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%--     <%@ include file="/JSP/Expirepage.jsp" %> --%>
<!DOCTYPE html>
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
      width:100%;
      
    }
 
th { 
    background-color: grey;
    color: white;
    height:30px;
}


table#view , th, #view td {
    border: 1px solid black;
    text-align:center;
}</style>

</head>
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

<h3 style="text-align:center">ALL ACCOUNT STATUS</h3>

 <% 
 
List<Accountstatus> listaccountstatus=(List<Accountstatus>)request.getAttribute("list");
 
%> 

<%  String msg =(String)request.getAttribute("message");
if(msg!=null){ %>

<h3 style="color:red"><%=msg %></h3>
<%} %>

<form action="<%=request.getContextPath()%>/servletcontrol" method="post">
<table>
<tr>
<td><input type="text" name="search" >
<button type="submit" name="action" value="searchbyAccountIdandType">Search</button></td>
</tr>
</table>
</form>


<table  border="1" id="view">
<tr>
        <th style="column-width:120px">Customer ID</th>
        <th style="column-width:150px">Account ID</th>
        <th style="column-width:150px">Account Type</th>
        <th style="column-width:100px">Status</th>
        <th style="column-width:150px">Message</th>
        <th style="column-width:150px">LastUpdated</th>
       
</tr>

<% for(Accountstatus acc:listaccountstatus)
	{
	%>
<tr>
<td><%=acc.getCustomerid() %></td>
<td> <%=acc.getAccountid()%> </td> 
<td> <%=acc.getAccounttype()%> </td>
<td><%=acc.getStatus()%></td>
<td><%=acc.getMessage()%></td>
<td><%=acc.getLastupdated()%></td>
</tr>

<%} %>
</table>
</article>
<footer>Copyright & Retail Banking.com</footer>

</div>
</body>
</html>
