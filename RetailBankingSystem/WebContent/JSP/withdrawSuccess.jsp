<%@page import="com.tcs.Models.CustomerandAccount"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%--     <%@ include file="/JSP/Expirepage.jsp" %> --%>
<!DOCTYPE html >
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
    
    
      border-left: 2px solid gray; 
    padding: 3em;
    overflow: hidden;  
}

article h1{
	/*Do styling inside the article elements*/
	
}



table#view  { 
      border-collapse: collapse; 
      width: 100%;
     
   
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

<nav>
<ul>
<li><a href="<%=request.getContextPath()%>/servletcontrol?action=Homepage">Home</a></li>
<li><a href="<%=request.getContextPath()%>/servletcontrol?action=viewCustomerandAccountDetails">View ALL Customer And Account Details</a></li>
<li><a href="<%=request.getContextPath()%>/servletcontrol?action=viewAllCustomerTransactions">View All Customer Transactions</a></li>
<li><a href="<%=request.getContextPath()%>/servletcontrol?action=Logout">Logout</a></li>
</ul>
</nav>

<article>

<% CustomerandAccount custandacc=(CustomerandAccount)request.getAttribute("custandacc"); 
int balancebefore=(int)request.getAttribute("balancebefore");%>



<h3 style="color:green">Amount Withdrawn Successfully</h3><br>
<p>Customer ID:<%=custandacc.getCustomerid()%> </p>
<p>Customer Name:<%=custandacc.getCustname()%></p>
<p>Account ID:<%=custandacc.getAccountid()%></p>
<p>Account Type:<%=custandacc.getAccounttype()%></p>
<p>Balance Before Withdrawn:<%=balancebefore%></p>
<p>Latest Balance:<%=custandacc.getBalance()%></p>
</article>

<footer>Copyright @ Retail Banking.com</footer>

</div>
</body>
</html>