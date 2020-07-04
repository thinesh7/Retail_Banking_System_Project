<%@page import="com.tcs.Models.CustomerandAccount"%>
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
form{

padding-left:200px;
}


article {
     margin-left:100px; 
    
      border-left: 2px solid gray; 
    padding: 2em;
    overflow: hidden;  
}

#sourceid{

float:left;
 max-width:250px;
    margin: 0;
    padding:1em;

}

#targetid{

float:right;
    margin: 0;
    padding:1em;
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

<nav>
<ul>
<li><a href="<%=request.getContextPath()%>/servletcontrol?action=Homepage">Home</a></li>
<li><a href="<%=request.getContextPath()%>/servletcontrol?action=viewCustomerandAccountDetails">View ALL Customer And Account Details</a></li>
<li><a href="<%=request.getContextPath()%>/servletcontrol?action=viewAllCustomerTransactions">View All Customer Transactions</a></li>
<li><a href="<%=request.getContextPath()%>/servletcontrol?action=Logout">Logout</a></li>
</ul>
</nav>

<article>

<% CustomerandAccount sourcecustandacc=(CustomerandAccount)request.getAttribute("sourcecustandacc"); 
int soucebalancebefore=(int)request.getAttribute("soucebalancebefore");
CustomerandAccount targetcustandacc=(CustomerandAccount)request.getAttribute("targetcustandacc"); 
int tagetbalancebefore=(int)request.getAttribute("tagetbalancebefore");
%>

<h3 style="color:green">Amount Transfer Completed Successfully</h3><br>
<div id="sourceid">
<p>SOURCE ACCOUNT DETAILS</p>
<p>Customer ID:<%=sourcecustandacc.getCustomerid()%> </p>
<p>Customer Name:<%=sourcecustandacc.getCustname()%></p>
<p>Account ID:<%=sourcecustandacc.getAccountid()%></p>
<p>Account Type:<%=sourcecustandacc.getAccounttype()%></p>
<p>Balance Before Transfer:<%=soucebalancebefore%></p>
<p>Latest Balance:<%=sourcecustandacc.getBalance()%></p>

</div>
<div id="targetid">

<p>TARGET ACCOUNT DETAILS</p>

<p>Customer ID:<%=targetcustandacc.getCustomerid()%> </p>
<p>Customer Name:<%=targetcustandacc.getCustname()%></p>
<p>Account ID:<%=targetcustandacc.getAccountid()%></p>
<p>Account Type:<%=targetcustandacc.getAccounttype()%></p>
<p>Balance Before Transfer:<%=tagetbalancebefore%></p>
<p>Latest Balance:<%=targetcustandacc.getBalance()%></p>
</div>
</article>

<footer>Copyright @ Retail Banking.com</footer>

</div>
</body>
</html>