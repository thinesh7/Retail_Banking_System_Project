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
form{

padding-left:200px;
}


article {
     margin-left:100px; 
    
      border-left: 2px solid gray; 
    padding: 4em;
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

<% String accid=(String)session.getAttribute("accountid"); %>

<nav>
<ul>
<li><a href="<%=request.getContextPath()%>/servletcontrol?action=Homepage">Home</a></li>
<li><a href="<%=request.getContextPath()%>/servletcontrol?action=viewCustomerandAccountDetails">View ALL Customer And Account Details</a></li>
<li><a href="<%=request.getContextPath()%>/servletcontrol?action=viewAllCustomerTransactions">View All Customer Transactions</a></li>
<li><a href="<%=request.getContextPath()%>/servletcontrol?action=Logout">Logout</a></li>
</ul>
</nav>
<article>

<h3 Style="text-align:center;font-size:20px ">Deposit form</h3>


<form action="<%=request.getContextPath()%>/servletcontrol?accid=<%=accid%>" method="post">
<table>
<tr><td>Account ID:</td><td><input type="text" value="<%=accid%>"></td></tr>
<tr><td>Enter the Amount to be Deposit:</td>
<td><input type="number" name="amount" required="required"></td>
</tr>
<tr><td><button type="submit" name="action" value="deposit">Deposit</button></td>
<td><button type="submit" name="action" value="transferCancel">Cancel</button></td></tr></table></form>
</article>

<footer>Copyright @ Retail Banking.com</footer>

</div>
</body>
</html>