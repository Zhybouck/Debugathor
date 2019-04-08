package fr.formation.dao;
// Generated 5 avr. 2019 11:04:33 by Hibernate Tools 5.1.10.Final

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import fr.formation.beans.Proposition;

/**
 * Home object for domain model class Proposition.
 * @see fr.formation.dao.Proposition
 * @author Hibernate Tools
 */
public class PropositionHome implements IPropositionDAO {

	private static final Log log = LogFactory.getLog(PropositionHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	/* (non-Javadoc)
	 * @see fr.formation.dao.IPropositionDAO#persist(fr.formation.beans.Proposition)
	 */
	public void persist(Proposition transientInstance) {
		log.debug("persisting Proposition instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see fr.formation.dao.IPropositionDAO#attachDirty(fr.formation.beans.Proposition)
	 */
	public void attachDirty(Proposition instance) {
		log.debug("attaching dirty Proposition instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see fr.formation.dao.IPropositionDAO#attachClean(fr.formation.beans.Proposition)
	 */
	public void attachClean(Proposition instance) {
		log.debug("attaching clean Proposition instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see fr.formation.dao.IPropositionDAO#delete(fr.formation.beans.Proposition)
	 */
	public void delete(Proposition persistentInstance) {
		log.debug("deleting Proposition instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see fr.formation.dao.IPropositionDAO#merge(fr.formation.beans.Proposition)
	 */
	public Proposition merge(Proposition detachedInstance) {
		log.debug("merging Proposition instance");
		try {
			Proposition result = (Proposition) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see fr.formation.dao.IPropositionDAO#findById(int)
	 */
	public Proposition findById(int id) {
		log.debug("getting Proposition instance with id: " + id);
		try {
			Proposition instance = (Proposition) sessionFactory.getCurrentSession().get("fr.formation.dao.Proposition",
					id);
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

	/* (non-Javadoc)
	 * @see fr.formation.dao.IPropositionDAO#findByExample(fr.formation.beans.Proposition)
	 */
	public List<Proposition> findByExample(Proposition instance) {
		log.debug("finding Proposition instance by example");
		try {
			List<Proposition> results = (List<Proposition>) sessionFactory.getCurrentSession()
					.createCriteria("fr.formation.dao.Proposition").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
