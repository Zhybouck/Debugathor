package fr.formation.dao;
// Generated 5 avr. 2019 11:04:33 by Hibernate Tools 5.1.10.Final

import static org.hibernate.criterion.Example.create;


import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import fr.formation.entities.Utilisateur;
import fr.formation.utils.HibernateUtils;

/**
 * Home object for domain model class Utilisateur.
 * @see fr.formation.dao.Utilisateur
 * @author Hibernate Tools
 */

@Repository
public class UtilisateurDAO implements IUtilisateurDAO {

	private static final Log log = LogFactory.getLog(UtilisateurDAO.class);

	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

	public UtilisateurDAO() {
		// TODO Auto-generated constructor stub
	}
	
//	protected SessionFactory getSessionFactory() {
//		try {
//			return (SessionFactory) new InitialContext().lookup("SessionFactory");
//		} catch (Exception e) {
//			log.error("Could not locate SessionFactory in JNDI", e);
//			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
//		}
//	}

	/* (non-Javadoc)
	 * @see fr.formation.dao.IUtilisateurDAO#persist(fr.formation.beans.Utilisateur)
	 */
	public void persist(Utilisateur transientInstance) {
		log.debug("persisting Utilisateur instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see fr.formation.dao.IUtilisateurDAO#attachDirty(fr.formation.beans.Utilisateur)
	 */
	public void attachDirty(Utilisateur instance) {
		log.debug("attaching dirty Utilisateur instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see fr.formation.dao.IUtilisateurDAO#attachClean(fr.formation.beans.Utilisateur)
	 */
	public void attachClean(Utilisateur instance) {
		log.debug("attaching clean Utilisateur instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see fr.formation.dao.IUtilisateurDAO#delete(fr.formation.beans.Utilisateur)
	 */
	public void delete(Utilisateur persistentInstance) {
		log.debug("deleting Utilisateur instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see fr.formation.dao.IUtilisateurDAO#merge(fr.formation.beans.Utilisateur)
	 */
	public Utilisateur merge(Utilisateur detachedInstance) {
		log.debug("merging Utilisateur instance");
		try {
			Utilisateur result = (Utilisateur) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see fr.formation.dao.IUtilisateurDAO#findById(java.lang.Integer)
	 */
	public Utilisateur findById(java.lang.Integer id) {
		log.debug("getting Utilisateur instance with id: " + id);
		  Session session = sessionFactory.getCurrentSession();
	        Transaction tx = session.getTransaction();
	        Utilisateur user = null;

	        try {
	            tx.begin();
	            user=session.get(Utilisateur.class, id);
	            tx.commit();
	        }
	        catch(HibernateException e) {
	            log.error(e.getLocalizedMessage());
	            if(tx!=null) {
	                try {
	                    tx.rollback();
	                }
	                catch(Exception e1) {
	                    log.error("Rollback : "+ e.getLocalizedMessage());
	                }
	            }
	            e.printStackTrace();
	        }
	            finally {
	            if(session!=null) {
	                session.close();
	            }
	        }
	        return user;

	    }

	/* (non-Javadoc)
	 * @see fr.formation.dao.IUtilisateurDAO#findByExample(fr.formation.beans.Utilisateur)
	 */
	public List<Utilisateur> findByExample(Utilisateur instance) {
		log.debug("finding Utilisateur instance by example");
		try {
			List<Utilisateur> results = (List<Utilisateur>) sessionFactory.getCurrentSession()
					.createCriteria("fr.formation.dao.Utilisateur").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}



	@Override
	public List<Utilisateur> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur getByMail(String mail) {
		log.debug("getting Utilisateur instance with nom: " + mail);
		try {
			Utilisateur instance = (Utilisateur) sessionFactory.getCurrentSession().get("fr.formation.dao.Utilisateur",
					mail);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
	}
	}

}
