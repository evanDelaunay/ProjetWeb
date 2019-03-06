<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<body>
	<h2>Hello World! Hey</h2>
	<%
		out.print("Baptiste le con</br>");
		out.print(request.getMethod() + "</br>");
		out.print(session.getId());
	%>
</body>
</html>
