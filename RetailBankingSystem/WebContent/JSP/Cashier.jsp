<%@page import="com.tcs.Models.Login"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%--         <%@ include file="/JSP/Expirepage.jsp" %> --%>
    
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




header, footer {
    padding: 1em;
    color: white;
    background-color:gray;
    clear: left; 
    text-align: center;
    border: 1px solid black;
    
}

a{
	 text-decoration: none;
}
nav {
    float: left;
    max-width:300px;
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
    padding: 3em;
    overflow: hidden;  
}

article h1{
	/*Do styling inside the article elements*/
	
}
form{
margin-left:100px;
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
    text-align: center;
}
</style>
</head>
<body>

<div class="container">

<header><h2>Retail Banking System</h2></header>

 <% Login login=(Login)request.getAttribute("login");%>

<nav>
<ul>
<li><a href="<%=request.getContextPath()%>/servletcontrol?action=Homepage">Home</a></li>
<li><a href="<%=request.getContextPath()%>/servletcontrol?action=viewCustomerandAccountDetails">View ALL Customer And Account Details</a></li>
<li><a href="<%=request.getContextPath()%>/servletcontrol?action=viewAllCustomerTransactions">View All Customer Transactions</a></li>
<li><a href="<%=request.getContextPath()%>/servletcontrol?action=Logout">Logout</a></li>
</ul>
</nav>
<article>

<p style="text-align:right;font-size: 20px">Welcome:<%=login.getUsername()%></p>

<%-- <form action="<%=request.getContextPath()%>/servletcontrol" method="post">
<table>
<tr>
<td><input type="text" name="search" >
<button type="submit" name="action" value="searchbyssnIdandAccountid">Search</button></td>
</tr>
</table>
</form>

 --%>
 </article>
 
 <footer>Copyright @ Retail Banking.com</footer>
 
 </div>

</body>
</html>