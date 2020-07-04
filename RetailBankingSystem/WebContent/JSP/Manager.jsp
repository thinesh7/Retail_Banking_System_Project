<%@page import="com.tcs.Models.Login"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%--     <%@ include file="/JSP/Expirepage.jsp" %> --%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retail Banking System</title>
<!-- <link rel="stylesheet" type="text/css" href="../CSS/Retail.css"> -->

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
    padding: 5em;
    overflow: hidden;  
}

article h1{
	/*Do styling inside the article elements*/
	
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
<li ><a href="<%=request.getContextPath()%>/servletcontrol?action=Customerreg">Customer Register</a></li>
<li><a href="<%=request.getContextPath()%>/servletcontrol?action=viewAllCustomerStatus">View ALL Customer Status</a></li>
<li><a href="<%=request.getContextPath()%>/servletcontrol?action=viewAllAccountStatus">View All Account Status</a></li>
<li><a href="<%=request.getContextPath()%>/servletcontrol?action=AllCustomer">AllCustomer</a></li>
<li><a href="<%=request.getContextPath()%>/servletcontrol?action=Logout">Logout</a></li>
</ul>
</nav>
<article>
<p style="text-align:right;font-size: 20px">Welcome:<%=login.getUsername()%></p>
</article>

<footer>Copyright @ Retail Banking.com</footer>

</div>

</body>
</html>