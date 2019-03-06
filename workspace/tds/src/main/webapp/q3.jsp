<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="compteur.Compteur"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		Compteur compteur;
		if (session.getAttribute("compteur") == null)
			compteur = new Compteur();
		else
			compteur = (Compteur) session.getAttribute("compteur");
		compteur.increment();
		out.print(compteur.getNboccurence());
		session.setAttribute("compteur", compteur);
	%>

	<%
		Compteur compteur1;
		if (application.getAttribute("compteur1") == null)
			compteur1 = new Compteur();
		else
			compteur1 = (Compteur) application.getAttribute("compteur1");
		compteur1.increment();
		out.print(compteur1.getNboccurence());
		application.setAttribute("compteur1", compteur1);
	%>

</body>
</html>