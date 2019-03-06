<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	if(request.getParameter("champFormHtmlTexte") != null && !request.getParameter("champFormHtmlTexte").isEmpty())
		out.print(request.getParameter("champFormHtmlTexte"));
	else
		response.sendRedirect("q2.html");
%>


</body>
</html>