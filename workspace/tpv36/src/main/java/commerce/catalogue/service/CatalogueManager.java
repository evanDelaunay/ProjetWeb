/**
 * Title:        commerce
 * Description:  Class for e-commerce
 * Company:      IUT Laval - Université du Maine
 * @author  A. Corbière
 */

package commerce.catalogue.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Query;

import commerce.catalogue.domaine.modele.Article;
import commerce.catalogue.domaine.modele.Piste;
import commerce.catalogue.domaine.utilitaire.HibernateUtil;
import commerce.catalogue.domaine.utilitaire.UniqueKeyGenerator;

public class CatalogueManager {

	private List articles; 
	
	public Article chercherArticleParRef(String inRefArticle) throws Exception {
		Article article ;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
		try {
			session.beginTransaction();
			article = (Article) session.get(Article.class, inRefArticle) ;
			session.getTransaction().commit();
		}
		catch (RuntimeException e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
			throw e; 
		}
		return (article) ;
	}
	public void supprimerArticleParRef(String inRefArticle) throws Exception {
		Article article ;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
		try {
			session.beginTransaction();
			article = (Article)session.get(Article.class, inRefArticle) ;
			session.delete(article) ;
			session.getTransaction().commit();
		}
		catch (RuntimeException e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
			throw e; 
		}
	}
	public void soumettreArticle(Article inArticle) throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
		try {
			session.beginTransaction();
			if (inArticle.getRefArticle() == null) {
				inArticle.setRefArticle(new UniqueKeyGenerator().getUniqueId()) ;
				session.save(inArticle) ;
			}
			else {
				session.saveOrUpdate(inArticle) ;
			}
			session.getTransaction().commit();
		}
		catch (RuntimeException e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
			throw e; 
		}
	}
	public void soumettrePiste(Piste inPiste) throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
		try {
			session.beginTransaction();
			if (inPiste.getRefPiste() == null) {
				inPiste.setRefPiste(new UniqueKeyGenerator().getUniqueId()) ;
				session.save(inPiste) ;
			}
			else {
				session.saveOrUpdate(inPiste) ;
			}
			session.getTransaction().commit();
		}
		catch (RuntimeException e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
			throw e; 
		}
	}
	public void setArticles(List inArticles) throws Exception {
		articles = inArticles;
	}
	public List getArticles() throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
		try {
			session.beginTransaction();
			//Query query = session.createQuery("from commerce.catalogue.domaine.modele.Article") ;
			//Question 6.1 td3
			//Query query = session.createQuery("from commerce.catalogue.domaine.modele.Livre") ;
			//Question 6.2 td3
			/*Query query = session.createQuery("from commerce.catalogue.domaine.modele.Article as m where "
					+" upper(m.titre) like upper(:paramMotCle)") ;
					query.setParameter("paramMotCle", "%illUsiOns%") ;*/
			//Question 6.3 td3
					Query query = session.createQuery("from commerce.catalogue.domaine.modele.Article as a where "
							+"a.prix>10 and a.prix<15") ;
			articles = query.list() ;
			session.getTransaction().commit();
		}
		catch (RuntimeException e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
			throw e; 
		}
		return articles ;
	}
}