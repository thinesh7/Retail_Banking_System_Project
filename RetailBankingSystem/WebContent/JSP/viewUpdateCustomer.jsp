
<%@page import="com.tcs.Models.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%--     <%@ include file="/JSP/Expirepage.jsp" %> --%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retail Banking System</title>

</head>
<body>
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

form{

margin-left:400px;

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

<h3 Style="text-align:center;font-size:25px;padding-top:10px ">Customer Update Status</h3>

<%  //String msg=(String)request.getAttribute("message");
 
Customer custom=(Customer)request.getAttribute("customer");

%>





<%-- <p style="color:red;font-size:22px"><%=msg%></p> <%} %> --%>

<form action="<%=request.getContextPath()%>/servletcontrol" method="post">
<table >
<tr><td>Customer SSNID:</td><td><input type="text" name="custssnid"  value="<%=custom.getCustssnid()%>" readonly="readonly"></td></tr> 
<tr><td>Customer Name:</td><td><input type="text" name="name" required="required" value="<%=custom.getCustomername() %>" ></td></tr>
<tr><td>Age:</td><td><input type="number" name="age" required="required" value="<%=custom.getAge()%>"></td></tr>
<tr><td>Addressline1:</td><td><input type="text" name="addressline1" required="required" value="<%=custom.getAddressline1()%>"></td></tr>
<tr><td>Addressline2:</td><td><textarea  name="addressline2" required="required"><%=custom.getAddressline2()%></textarea></td></tr>
<tr><td>State:</td><td><input type="text" name="state" required="required" value="<%=custom.getState()%>"></td></tr>
<tr><td>City:</td><td><input type="text" name="city" required="required" value="<%=custom.getCity()%>"></td></tr>

<tr><td><button type="submit" name="action" value="UpadateCustomer" >Submit</button>
<td><button type="reset" name="action" value="UpadateCustomercancel">Cancel</button></td></tr>
</table>
</form>
</article>
<footer>Copyright & Retail Banking.com</footer>

</div>
</body>
</html>