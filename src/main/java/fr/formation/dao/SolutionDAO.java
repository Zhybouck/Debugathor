package fr.formation.dao;
// Generated 15 avr. 2019 13:36:33 by Hibernate Tools 5.1.10.Final

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import fr.formation.entities.Proposition;
import fr.formation.entities.Solution;
import fr.formation.entities.Utilisateur;

/**
 * Home object for domain model class Solution.
 * @see fr.formation.dao.Solution
 * @author Hibernate Tools
 */

@Repository("solutionDao")
public class SolutionDAO extends GenericDAO<Solution> implements ISolutionDAO{

	private static final Log log = LogFactory.getLog(SolutionDAO.class);

	public SolutionDAO() {
		setClazz(Solution.class);
	}
	
	@Override
	public List<Solution> getByDateInsc(Date debut,Date fin){
		Session session = sessionFactory.getCurrentSession();
		
		//on passe du format java au format sql pour les dates
		java.sql.Date debutsql=new java.sql.Date(debut.getTime());
		java.sql.Date finsql=new java.sql.Date(fin.getTime());
		
        // create Criteria
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Solution> criteriaQuery = builder.createQuery(Solution.class);
        Root<Solution> root = criteriaQuery.from(Solution.class);
        criteriaQuery.where(builder.between(root.get("dateBug"), debutsql, finsql));
        List<Solution> listutil  = session.createQuery(criteriaQuery).getResultList();
//        session.close();

        return listutil;
		
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
//	public void persist(Solution transientInstance) {
//		log.debug("persisting Solution instance");
//		try {
//			sessionFactory.getCurrentSession().persist(transientInstance);
//			log.debug("persist successful");
//		} catch (RuntimeException re) {
//			log.error("persist failed", re);
//			throw re;
//		}
//	}
//
//	public void attachDirty(Solution instance) {
//		log.debug("attaching dirty Solution instance");
//		try {
//			sessionFactory.getCurrentSession().saveOrUpdate(instance);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(Solution instance) {
//		log.debug("attaching clean Solution instance");
//		try {
//			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	public void delete(Solution persistentInstance) {
//		log.debug("deleting Solution instance");
//		try {
//			sessionFactory.getCurrentSession().delete(persistentInstance);
//			log.debug("delete successful");
//		} catch (RuntimeException re) {
//			log.error("delete failed", re);
//			throw re;
//		}
//	}
//
//	public Solution merge(Solution detachedInstance) {
//		log.debug("merging Solution instance");
//		try {
//			Solution result = (Solution) sessionFactory.getCurrentSession().merge(detachedInstance);
//			log.debug("merge successful");
//			return result;
//		} catch (RuntimeException re) {
//			log.error("merge failed", re);
//			throw re;
//		}
//	}
//
//	public Solution findById(java.lang.Integer id) {
//		log.debug("getting Solution instance with id: " + id);
//		try {
//			Solution instance = (Solution) sessionFactory.getCurrentSession().get("fr.formation.dao.Solution", id);
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
//	public List<Solution> findByExample(Solution instance) {
//		log.debug("finding Solution instance by example");
//		try {
//			List<Solution> results = (List<Solution>) sessionFactory.getCurrentSession()
//					.createCriteria("fr.formation.dao.Solution").add(create(instance)).list();
//			log.debug("find by example successful, result size: " + results.size());
//			return results;
//		} catch (RuntimeException re) {
//			log.error("find by example failed", re);
//			throw re;
//		}
//	}

	
}
