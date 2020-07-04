

<%

session=request.getSession(true);

response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires",0);
if(session==null || session.getAttribute("login")==null){
	
	response.sendRedirect(request.getContextPath()+"/JSP/Login.jsp");	
return;
	
}

%>
