package fr.formation.dao;
// Generated 5 avr. 2019 11:04:33 by Hibernate Tools 5.1.10.Final

import static org.hibernate.criterion.Example.create;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.formation.beans.Logiciel;
import fr.formation.utils.HibernateUtils;

/**
 * Home object for domain model class Logiciel.
 * 
 * @see fr.formation.dao.Logiciel
 * @author Hibernate Tools
 */
public class LogicielHome implements ISolutionDAO, ILogicielDAO {

	private static final Log log = LogFactory.getLog(LogicielHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return HibernateUtils.getSessionFactory();
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.formation.dao.ISolutionDAO#persist(fr.formation.beans.Logiciel)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.formation.dao.ILogicielDAO#persist(fr.formation.beans.Logiciel)
	 */
	public void persist(Logiciel transientInstance) {
		log.debug("persisting Logiciel instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.formation.dao.ISolutionDAO#attachDirty(fr.formation.beans.Logiciel)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.formation.dao.ILogicielDAO#attachDirty(fr.formation.beans.Logiciel)
	 */
	public void attachDirty(Logiciel instance) {
		log.debug("attaching dirty Logiciel instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.formation.dao.ISolutionDAO#attachClean(fr.formation.beans.Logiciel)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.formation.dao.ILogicielDAO#attachClean(fr.formation.beans.Logiciel)
	 */
	public void attachClean(Logiciel instance) {
		log.debug("attaching clean Logiciel instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.formation.dao.ISolutionDAO#delete(fr.formation.beans.Logiciel)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.formation.dao.ILogicielDAO#delete(fr.formation.beans.Logiciel)
	 */
	public void delete(Logiciel persistentInstance) {
		log.debug("deleting Logiciel instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.formation.dao.ISolutionDAO#merge(fr.formation.beans.Logiciel)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.formation.dao.ILogicielDAO#merge(fr.formation.beans.Logiciel)
	 */
	public Logiciel merge(Logiciel detachedInstance) {
		log.debug("merging Logiciel instance");
		try {
			Logiciel result = (Logiciel) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.formation.dao.ISolutionDAO#findById(int)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.formation.dao.ILogicielDAO#findById(int)
	 */
	public Logiciel findById(int id) {
		log.debug("getting Logiciel instance with id: " + id);
		try {
			sessionFactory.getCurrentSession().getTransaction().begin();
			Logiciel instance = (Logiciel) sessionFactory.getCurrentSession().get(Logiciel.class.getName(), id);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.formation.dao.ISolutionDAO#findByExample(fr.formation.beans.Logiciel)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.formation.dao.ILogicielDAO#findByExample(fr.formation.beans.Logiciel)
	 */
	public List<Logiciel> findByExample(Logiciel instance) {
		log.debug("finding Logiciel instance by example");
		try {
			List<Logiciel> results = (List<Logiciel>) sessionFactory.getCurrentSession()
					.createCriteria("fr.formation.dao.Logiciel").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<Logiciel> getAll() {
//		CriteriaBuilder builder = session.getCriteriaBuilder();
//		CriteriaQuery<Logiciel> criteria = builder.createQuery(Logiciels);
//		criteria.from(Logiciels);
//		List<Logiciel> liste = session.createQuery(criteria).getResultList();
//		return liste;
        Session session = sessionFactory.openSession();

        // create Criteria
        CriteriaQuery<Logiciel> criteriaQuery = session.getCriteriaBuilder().createQuery(Logiciel.class);
        criteriaQuery.from(Logiciel.class);

        List<Logiciel> liste = session.createQuery(criteriaQuery).getResultList();
        session.close();

        return liste;
//	    try
//	    {
//	        return sessionFactory.getCurrentSession().createCriteria(Logiciel.class).list();
//	    } catch (Exception e) {
//	        return new ArrayList<>();
//	    }
	}
}
