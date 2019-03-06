package commerce.gestion;

import commerce.catalogue.domaine.modele.Livre;

/**
 * Title: commerce Description: Class for e-commerce Company: IUT Laval -
 * Université du Maine
 * 
 * @author A. Corbière
 * @version 1.0, 26/02/07
 */

public class LignePanier {
	private Livre livre;
	private double prixUnitaire;
	private double prixTotal;
	private int quantite;

	public void setLivre(Livre inLivre) {
		livre = inLivre;
		prixUnitaire = livre.getPrix();
	}

	public Livre getLivre() {
		return livre;
	}

	public void setPrixUnitaire(double inPrixUnitaire) {
		prixUnitaire = inPrixUnitaire;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public double getPrixTotal() {
		recalculer();
		return (prixTotal);
	}

	public void setQuantite(int inQuantite) {
		quantite = inQuantite;
	}

	public int getQuantite() {
		return quantite;
	}

	public void recalculer() {
		prixTotal = prixUnitaire * quantite;
	}

	public boolean equals(Object o) {
		boolean retour = false;
		if (!(o instanceof LignePanier))
			retour = false;
		else {
			LignePanier inLignePanier = (LignePanier) o;
			if (this.getLivre().equals(inLignePanier.getLivre()) && this.getQuantite() == inLignePanier.getQuantite())
				retour = true;
			else
				retour = false;
		}
		return retour;
	}
}
