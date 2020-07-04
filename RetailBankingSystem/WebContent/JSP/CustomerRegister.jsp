<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%--   <%@ include file="/JSP/Expirepage.jsp" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retail Banking System</title>
<link rel="stylesheet" type="text/css" href="../CSS/Retail.css">

</head>
<body >
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

<h3 Style="text-align:center;font-size:20px ">Customer Register</h3>

<%  String msg=(String)request.getAttribute("message");
if(msg!=null)
{%>

<p style="color:red;font-size:22px"><%=msg%></p>
<%} %>

<form id="regiesterformid" action="<%=request.getContextPath()%>/servletcontrol" method="post">
<table>
<tr><td>Customer SSN ID:</td><td><input type="text" name="custssnid" required="required"></td></tr> 
<tr><td>Customer Name:</td><td><input type="text" name="name" required="required"></td></tr>
<tr><td>Age:</td><td><input type="number" name="age" required="required"></td></tr>
<tr><td>Address Line1:</td><td><input type="text" name="addressline1" required="required"></td></tr>
<tr><td>Address Line2:</td><td><input type="text" name="addressline2" required="required"></td></tr>
<tr><td>State:</td><td><select name="state" required><option>---select---</option>
<option value="Tamilnadu">Tamilnadu</option><option value="Kerala">Kerala</option></select></td></tr>
<tr><td>City:</td><td><select name="city" required><option>---select---</option>
<option value="Coimbatore">Coimbatore</option><option value="Cochin">Cochin</option></select></td></tr>
<tr><td><button type="submit" name="action" value="CheckCustomerreg">Register</button></td>
<td><button type="reset" >Cancel</button></td></tr>
</table>
</form>
</article>
<footer>Copyright @ Retail Banking.com</footer>
</div>
</body>
</html>