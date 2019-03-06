package commerce.catalogue.domaine.modele;

import javax.persistence.Id ;
import javax.persistence.Basic ;
import javax.persistence.Entity ;

/**
 * Title:        commerce
 * Description:  Class for e-commerce
 * Company:      IUT Laval - Université du Maine
 * Author  A. Corbière
 */

@Entity (name="commerce.catalogue.domaine.modele.Livre")
public class Livre {
	private String refLivre; 
	private String titre;
	private String auteur;
	private String ISBN;
	private int nbPages;
	private String langue;
	private String image;
	private String dateDeParution;
	private double prix;
	private int disponibilite;

	@Id
	public String getRefLivre() {
		return refLivre;
	}
	public void setRefLivre(String inRefLivre) {
		refLivre = inRefLivre;
	}

	@Basic
	public String getTitre() {
		return titre;
	}
	public void setTitre(String inTitre) {
		titre = inTitre;
	}	  
	
	@Basic
	 public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String inAuteur) {
		auteur = inAuteur;
	}
	
	@Basic
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String inISBN) {
		ISBN = inISBN;
	}
	
	@Basic
	public int getNbPages() {
		return nbPages;
	}
	public void setNbPages(int inNbPages) {
		nbPages = inNbPages;
	}
	
	@Basic
	public String getLangue() {
		return langue;
	}
	public void setLangue(String inLangue) {
		langue = inLangue;
	}
	
	@Basic
	public String getImage() {
		return image;
	}
	public void setImage(String inImage) {
		image = inImage;
	}
	
	@Basic
	public String getDateDeParution() {
		return dateDeParution;
	}
	public void setDateDeParution(String inDateDeParution) {
		dateDeParution = inDateDeParution;
	}
	
	@Basic
	public double getPrix() {
		return prix;
	}
	public void setPrix(double inPrix) {
		prix = inPrix;
	}
	public void setPrix(String inPrix) {
		prix = Double.parseDouble(inPrix);
	}
	
	@Basic
	public int getDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(String inDisponibilite) {
		disponibilite = Integer.parseInt(inDisponibilite);
	}
	public void setDisponibilite(int inDisponibilite) {
		disponibilite = inDisponibilite;
	}

	public boolean equals(Object o) {
		boolean retour = false ;
		if (!(o instanceof Livre))
			retour = false ;
		else {
			Livre inLivre = (Livre)o ;
			if (this.getRefLivre().equals(inLivre.getRefLivre()))
				retour = true ;
			else
				retour = false ;
		}
		return retour ;
	}
}
