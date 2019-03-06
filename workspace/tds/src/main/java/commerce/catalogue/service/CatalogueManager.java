/**
 * Title:        commerce
 * Description:  Class for e-commerce
 * Company:      IUT Laval - Université du Maine
 * @author  A. Corbière
 * @version 1.5, 06/01/14
 */

package commerce.catalogue.service;

import java.util.List ;

import org.hibernate.Session ;
import commerce.catalogue.domaine.modele.Livre;
import commerce.catalogue.domaine.utilitaire.UniqueKeyGenerator;
import commerce.catalogue.domaine.utilitaire.HibernateUtil;

public class CatalogueManager {
	private List<Livre> livres; 
	public CatalogueManager() throws Exception {
		initData() ;
	}
	public Livre chercherLivreParRef(String inRefLivre) throws Exception {
		Livre livre = new Livre() ;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
		session.beginTransaction();
		livre = (Livre)session.get(Livre.class, inRefLivre) ;
		session.getTransaction().commit();
		return (livre) ;
	}
	public void supprimerLivreParRef(String inRefLivre) throws Exception {
		Livre livre = new Livre() ;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
		session.beginTransaction();
		livre = (Livre)session.get(Livre.class, inRefLivre) ;
		session.delete(livre) ;
		session.getTransaction().commit();
	}
	public void soumettreLivre(Livre inLivre) throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
		session.beginTransaction();
		if (inLivre.getRefLivre() == null) {
		    inLivre.setRefLivre(new UniqueKeyGenerator().getUniqueId()) ;
			session.save(inLivre) ;
		}
		else {
			session.saveOrUpdate(inLivre) ;
		}
		session.getTransaction().commit();
	}
	public void setLivres(List<Livre> inLivres) throws Exception {
		livres = inLivres;
	}
	public List<Livre> getLivres() throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
		session.beginTransaction();
		livres = session.createQuery("from commerce.catalogue.domaine.modele.Livre").list();
		session.getTransaction().commit();
		return livres ;
	}
	private void initData() throws Exception {
		if (this.getLivres().size() == 0 ) {
			Livre livre = new Livre();
			livre.setRefLivre("1141555677821");
			livre.setTitre("Le seigneur des anneaux");
			livre.setAuteur("J.R.R. TOLKIEN");
			livre.setISBN("2266154117");
			livre.setImage("61PEbZ1QDfL.jpg");
			livre.setNbPages(697);
			livre.setLangue("fr");
			livre.setDateDeParution("19/03/05");
			livre.setPrix("6.80");
			livre.setDisponibilite("1");
			this.soumettreLivre(livre);
			livre = new Livre();
			livre.setRefLivre("1141555897821");
			livre.setTitre("Un paradis trompeur");
			livre.setAuteur("Henning Mankell");
			livre.setISBN("275784797X");
			livre.setImage("61NfUluHsML.jpg");
			livre.setNbPages(400);
			livre.setLangue("fr");
			livre.setDateDeParution("09/10/14");
			livre.setPrix("7.90");
			livre.setDisponibilite("1");
			this.soumettreLivre(livre);
			livre = new Livre();
			livre.setRefLivre("1141556299459");
			livre.setTitre("Dôme tome 1");
			livre.setAuteur("Stephen King");
			livre.setISBN("2212110685");
			livre.setImage("61sGE8edJmL.jpg");
			livre.setNbPages(840);
			livre.setLangue("fr");
			livre.setDateDeParution("06/03/13");
			livre.setPrix("8.90");
			livre.setDisponibilite("1");
			this.soumettreLivre(livre);
		}	  
	}
}
