<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat"%>

<html>
<body>
	<%
		String date = new SimpleDateFormat("[dd/MMM/yyyy:HH:mm:ss Z]").format(new Date());
		out.print(request.getRemoteAddr() + "- -" + date + "</br>");
	%>
	<h2>Question 9</h2>
	<%
		out.print(request.getLocale().getLanguage()+"<br>");
		out.print(request.getScheme() + "</br>");
		out.print(request.getRequestURI()+ "</br>");
		out.print(request.getQueryString() + "</br>");
		out.print(request.getRealPath("/"));
	%>
</body>
</html>
