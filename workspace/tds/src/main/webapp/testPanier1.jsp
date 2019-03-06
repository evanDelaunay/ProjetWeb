<%@ page contentType="text/plain; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page import="commerce.catalogue.domaine.modele.Livre"%>
<%@ page import="commerce.catalogue.service.CatalogueManager"%>
<%@ page import="commerce.gestion.Panier"%>
<%@ page import="commerce.gestion.LignePanier"%>
<%@ page import="java.util.Iterator"%>
<%
  // Initialisation du panier
  Panier panier = new Panier();
  CatalogueManager catalogueManager = new CatalogueManager() ;
  Livre livre = catalogueManager.chercherLivreParRef("1141555897821") ;
  panier.ajouterLigne(livre);
  livre = catalogueManager.chercherLivreParRef("1141556299459") ;
  panier.ajouterLigne(livre);
  // Affichage du contenu du panier:
  Iterator<LignePanier> it = panier.getLignesPanier().iterator();
  LignePanier ligne ;


  while (it.hasNext()) {
        ligne = (LignePanier)it.next();
        livre = ligne.getLivre();
        out.print(livre.getRefLivre());
        out.print(" - ");
        out.print(livre.getAuteur());
        out.print(" - ");
        out.print(ligne.getPrixUnitaire());
        out.print(" - ");
        out.print(ligne.getPrixTotal());
        out.print(" - ");
        out.print(ligne.getQuantite());
        out.println();
  }
  out.println("Total: " + panier.getTotal());
%>