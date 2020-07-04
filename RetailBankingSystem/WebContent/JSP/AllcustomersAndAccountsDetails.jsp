<%@page import="java.util.List"%>
<%@page import="com.tcs.Models.CustomerandAccount"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%--         <%@ include file="/JSP/Expirepage.jsp" %> --%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retail Banking System</title><style>div.container {
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
    height:30px;
}


table#view , th, #view td {
    border: 1px solid black;
    text-align:center;
}</style>
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
<h3 style="text-align:center">CUSTOMER AND ACCOUNT DETAILS</h3>

 <% 
 
List<CustomerandAccount> listcustomerandaccount=(List<CustomerandAccount>)request.getAttribute("list");
 

 String id=(String)request.getAttribute("id");
%> 

<%  String msg=(String)request.getAttribute("message");
if(msg!=null){ %>

<h3 style="color:red"><%=msg %></h3>
<%} %>

<form action="<%=request.getContextPath()%>/servletcontrol" method="post">
<table>
<tr>
<td><input type="text" name="search" >
<button type="submit" name="action" value="searchbyssnIdandAccountid">Search</button></td>
</tr>
</table>
</form>

<div style="overflow-x:auto;">
<table  border="1" id="view">
<tr>
        <th style="column-width:100px">Customer ID</th>
        <th style="column-width:140px">Customer SSN ID</th>
        <th style="column-width:120px">Customer Name</th>
        <th style="column-width:60px">Age</th>
        <th style="column-width:130px">AddressLine1</th>
        <th style="column-width:130px">AddressLine2</th>
        <th style="column-width:100px">State</th>
        <th style="column-width:100px">City</th>
        <th style="column-width:120px">Account ID</th>
        <th style="column-width:150px">Account Type</th>
        <th style="column-width:70px">Balance</th>
        <th style="column-width:150px" colspan="3">Transactions</th>
      
</tr>

<% for(CustomerandAccount custandacc:listcustomerandaccount)
	{
	%>
<tr>
<td><%=custandacc.getCustomerid() %></td>
<td> <%=custandacc.getCustomerssnid()%> </td> 
<td> <%=custandacc.getCustname() %> </td>
<td><%=custandacc.getAge() %></td>
<td><%=custandacc.getAddressline1() %></td>
<td><%=custandacc.getAddressline2()%></td>
<td><%=custandacc.getState() %></td>
<td><%=custandacc.getCity() %></td>
<td><%=custandacc.getAccountid()%></td>
<td><%=custandacc.getAccounttype()%></td>
<td><%=custandacc.getBalance()%></td>
<td><a href="<%=request.getContextPath()%>/servletcontrol?action=depositform&accountid=<%=custandacc.getAccountid()%>">Deposit</a></td>
<td><a href="<%=request.getContextPath()%>/servletcontrol?action=withdrawform&accountid=<%=custandacc.getAccountid()%>">Withdraw</a></td>
<td><a href="<%=request.getContextPath()%>/servletcontrol?action=transferform&accountid=<%=custandacc.getAccountid()%>">Transfer</a></td>
</tr>

<%} %>
</table>


</div>
</article>
<footer>Copyright @ Retail Banking.com</footer>

</div>
</body>
</html>
