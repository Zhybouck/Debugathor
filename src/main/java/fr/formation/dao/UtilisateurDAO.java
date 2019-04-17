package fr.formation.dao;
// Generated 15 avr. 2019 13:36:33 by Hibernate Tools 5.1.10.Final

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import fr.formation.entities.Utilisateur;

/**
 * Home object for domain model class Utilisateur.
 * @see fr.formation.dao.Utilisateur
 * @author Hibernate Tools
 */

@Repository("utilisateurDao")
public class UtilisateurDAO extends GenericDAO<Utilisateur> implements IUtilisateurDAO{

	private static final Log log = LogFactory.getLog(UtilisateurDAO.class);

	public UtilisateurDAO() {
		setClazz(Utilisateur.class);
	}
	
//	private final SessionFactory sessionFactory = getSessionFactory();
//
//	protected SessionFactory getSessionFactory() {
//		try {
//			return (SessionFactory) new InitialContext().lookup("SessionFactory");
//		} catch (Exception e) {
//			log.error("Could not locate SessionFactory in JNDI", e);
//			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
//		}
//	}
//
//	public void persist(Utilisateur transientInstance) {
//		log.debug("persisting Utilisateur instance");
//		try {
//			sessionFactory.getCurrentSession().persist(transientInstance);
//			log.debug("persist successful");
//		} catch (RuntimeException re) {
//			log.error("persist failed", re);
//			throw re;
//		}
//	}
//
//	public void attachDirty(Utilisateur instance) {
//		log.debug("attaching dirty Utilisateur instance");
//		try {
//			sessionFactory.getCurrentSession().saveOrUpdate(instance);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(Utilisateur instance) {
//		log.debug("attaching clean Utilisateur instance");
//		try {
//			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	public void delete(Utilisateur persistentInstance) {
//		log.debug("deleting Utilisateur instance");
//		try {
//			sessionFactory.getCurrentSession().delete(persistentInstance);
//			log.debug("delete successful");
//		} catch (RuntimeException re) {
//			log.error("delete failed", re);
//			throw re;
//		}
//	}
//
//	public Utilisateur merge(Utilisateur detachedInstance) {
//		log.debug("merging Utilisateur instance");
//		try {
//			Utilisateur result = (Utilisateur) sessionFactory.getCurrentSession().merge(detachedInstance);
//			log.debug("merge successful");
//			return result;
//		} catch (RuntimeException re) {
//			log.error("merge failed", re);
//			throw re;
//		}
//	}
//
//	public Utilisateur findById(java.lang.Integer id) {
//		log.debug("getting Utilisateur instance with id: " + id);
//		try {
//			Utilisateur instance = (Utilisateur) sessionFactory.getCurrentSession().get("fr.formation.dao.Utilisateur",
//					id);
//			if (instance == null) {
//				log.debug("get successful, no instance found");
//			} else {
//				log.debug("get successful, instance found");
//			}
//			return instance;
//		} catch (RuntimeException re) {
//			log.error("get failed", re);
//			throw re;
//		}
//	}
//
//	public List<Utilisateur> findByExample(Utilisateur instance) {
//		log.debug("finding Utilisateur instance by example");
//		try {
//			List<Utilisateur> results = (List<Utilisateur>) sessionFactory.getCurrentSession()
//					.createCriteria("fr.formation.dao.Utilisateur").add(create(instance)).list();
//			log.debug("find by example successful, result size: " + results.size());
//			return results;
//		} catch (RuntimeException re) {
//			log.error("find by example failed", re);
//			throw re;
//		}
//	}


}
