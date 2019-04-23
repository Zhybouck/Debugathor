package fr.formation.dao;
// Generated 15 avr. 2019 13:36:33 by Hibernate Tools 5.1.10.Final

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
