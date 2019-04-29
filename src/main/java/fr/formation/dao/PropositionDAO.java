package fr.formation.dao;
// Generated 15 avr. 2019 13:36:33 by Hibernate Tools 5.1.10.Final

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import fr.formation.entities.Proposition;
import fr.formation.entities.Solution;
import fr.formation.entities.Utilisateur;

/**
 * Home object for domain model class Proposition.
 * @see fr.formation.dao.Proposition
 * @author Hibernate Tools
 */

@Repository("propositionDao")
public class PropositionDAO extends GenericDAO<Proposition> implements IPropositionDAO{

	private static final Log log = LogFactory.getLog(PropositionDAO.class);
	
	public PropositionDAO() {
		setClazz(Proposition.class);
	}
	@Override
	public void save(Proposition obj) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.clear();
			session.save(obj);
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	/*
	 * Mets à jout l'objet obj dans la base de données
	 */
	@Override
	public void update(Proposition obj) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(obj);
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	/*
	 * supprime l'objet obj de la base de données
	 */
	@Override
	public void delete(Proposition obj) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.remove(obj);
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	/*
	 * recupère toute la liste d'objets
	 */
	@Override
	public List<Proposition> getAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaQuery<Proposition> criteria = session.getCriteriaBuilder().createQuery(Proposition.class);
		criteria.select(criteria.from(Proposition.class));
		return session.createQuery(criteria).getResultList();
	}

	
	/*
	 * récupère toutes les proposition d'un utilisateur entré en paramètre
	 */
	@Override
	public List<Proposition> findAllPropbyUser(Utilisateur util) {
		Session session = sessionFactory.getCurrentSession();

        // create Criteria
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Proposition> criteriaQuery = builder.createQuery(Proposition.class);
        Root<Proposition> root = criteriaQuery.from(Proposition.class);
        CriteriaQuery<Proposition> select = criteriaQuery.select(root);
        criteriaQuery.where(builder.equal(root.get("utilisateur"), util));
        List<Proposition> listProp = session.createQuery(criteriaQuery).getResultList();
//        session.close();

        return listProp;
	}
	
	/*
	 * récupère toutes les propositions pour une solution
	 */
	@Override
	public List<Proposition> findAllPropbySolution(Solution sol) {
		Session session = sessionFactory.getCurrentSession();

        // create Criteria
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Proposition> criteriaQuery = builder.createQuery(Proposition.class);
        Root<Proposition> root = criteriaQuery.from(Proposition.class);
        CriteriaQuery<Proposition> select = criteriaQuery.select(root);
        criteriaQuery.where(builder.equal(root.get("solution"), sol));
        List<Proposition> listProp = session.createQuery(criteriaQuery).getResultList();
//        session.close();

        return listProp;
	}
}
