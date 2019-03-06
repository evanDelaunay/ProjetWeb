<%@ page contentType="text/plain; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page import="commerce.catalogue.domaine.modele.Livre"%>
<%@ page import="commerce.catalogue.service.CatalogueManager"%>
<%
  CatalogueManager catalogueManager = new CatalogueManager() ;
  Livre livre1 = new Livre() ;
  livre1.setRefLivre("1141555897821") ;
  Livre livre2 = livre1 ;
  Livre livre3 = new Livre() ;
  livre3.setRefLivre("1141555897821") ;
  out.println(livre1.equals(livre2)) ;
  out.println(livre1.equals(livre3)) ;
%>
