package fr.formation.dao;
// Generated 15 avr. 2019 13:36:33 by Hibernate Tools 5.1.10.Final

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import fr.formation.entities.Logiciel;

/**
 * Home object for domain model class Logiciel.
 * @see fr.formation.dao.Logiciel
 * @author Hibernate Tools
 */
@Repository("logicielDao")
public class LogicielDAO extends GenericDAO<Logiciel> implements ILogicielDAO{

	private static final Log log = LogFactory.getLog(LogicielDAO.class);

	public LogicielDAO() {
		setClazz(Logiciel.class);
	}

	@Override
	public List<Logiciel> findByName(String name) {
		return null;
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
//	public void persist(Logiciel transientInstance) {
//		log.debug("persisting Logiciel instance");
//		try {
//			sessionFactory.getCurrentSession().persist(transientInstance);
//			log.debug("persist successful");
//		} catch (RuntimeException re) {
//			log.error("persist failed", re);
//			throw re;
//		}
//	}
//
//	public void attachDirty(Logiciel instance) {
//		log.debug("attaching dirty Logiciel instance");
//		try {
//			sessionFactory.getCurrentSession().saveOrUpdate(instance);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(Logiciel instance) {
//		log.debug("attaching clean Logiciel instance");
//		try {
//			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	public void delete(Logiciel persistentInstance) {
//		log.debug("deleting Logiciel instance");
//		try {
//			sessionFactory.getCurrentSession().delete(persistentInstance);
//			log.debug("delete successful");
//		} catch (RuntimeException re) {
//			log.error("delete failed", re);
//			throw re;
//		}
//	}
//
//	public Logiciel merge(Logiciel detachedInstance) {
//		log.debug("merging Logiciel instance");
//		try {
//			Logiciel result = (Logiciel) sessionFactory.getCurrentSession().merge(detachedInstance);
//			log.debug("merge successful");
//			return result;
//		} catch (RuntimeException re) {
//			log.error("merge failed", re);
//			throw re;
//		}
//	}
//
//	public Logiciel findById(int id) {
//		log.debug("getting Logiciel instance with id: " + id);
//		try {
//			Logiciel instance = (Logiciel) sessionFactory.getCurrentSession().get("fr.formation.dao.Logiciel", id);
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
//	public List<Logiciel> findByExample(Logiciel instance) {
//		log.debug("finding Logiciel instance by example");
//		try {
//			List<Logiciel> results = (List<Logiciel>) sessionFactory.getCurrentSession()
//					.createCriteria("fr.formation.dao.Logiciel").add(create(instance)).list();
//			log.debug("find by example successful, result size: " + results.size());
//			return results;
//		} catch (RuntimeException re) {
//			log.error("find by example failed", re);
//			throw re;
//		}
//	}
//
//	@Override
//	public Logiciel findById(Integer id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Logiciel> getAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Logiciel> findByName(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
