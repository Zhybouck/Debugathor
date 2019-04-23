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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.formation.entities.Logiciel;
import fr.formation.entities.Proposition;
import fr.formation.entities.PropositionId;
import fr.formation.entities.Solution;
import fr.formation.entities.Utilisateur;
import fr.formation.services.ILogicielService;

/**
 * Home object for domain model class Solution.
 * 
 * @see fr.formation.dao.Solution
 * @author Hibernate Tools
 */

@Repository("solutionDao")
public class SolutionDAO extends GenericDAO<Solution> implements ISolutionDAO {

	private static final Log log = LogFactory.getLog(SolutionDAO.class);

	public SolutionDAO() {
		setClazz(Solution.class);
	}

	@Autowired
	ILogicielService Logserv;

	/*
	 * recupère les solutions dont la date est comprise entre une date de début et une date de fin
	 */
	@Override
	public List<Solution> getByDateBug(Date debut, Date fin) {
		Session session = sessionFactory.getCurrentSession();
		// si aucune valeur n'est spécifiée on prends la valeur maximale pour "fin"
		if (fin == null) {
			fin = new Date(Long.MAX_VALUE);
		}
		// si aucune valeur n'est spécifiée on prends la valeur maximale pour "debut"
		if (debut == null) {
			debut = new Date(Long.MIN_VALUE);
		}

		// on passe du format java au format sql pour les dates
		java.sql.Date debutsql = new java.sql.Date(debut.getTime());
		java.sql.Date finsql = new java.sql.Date(fin.getTime());

		// create Criteria
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Solution> criteriaQuery = builder.createQuery(Solution.class);
		Root<Solution> root = criteriaQuery.from(Solution.class);
		criteriaQuery.where(builder.between(root.get("dateBug"), debutsql, finsql));
		List<Solution> listutil = session.createQuery(criteriaQuery).getResultList();
//        session.close();

		return listutil;

	}

	/*
	 * recupère les solutions par recherche dans le titre
	 */
	@Override
	public List<Solution> getByTitre(String titre) {
		Session session = sessionFactory.getCurrentSession();

		// create Criteria
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Solution> criteriaQuery = builder.createQuery(Solution.class);
		Root<Solution> root = criteriaQuery.from(Solution.class);
		criteriaQuery.where(builder.like(root.get("titre"), "%" + titre + "%"));
		List<Solution> listutil = session.createQuery(criteriaQuery).getResultList();
//        session.close();

		return listutil;
	}

	/*
	 * recupère les solutions liées a une technologie
	 */
	@Override
	public List<Solution> getByTechno(String technologie) {
		Session session = sessionFactory.getCurrentSession();

		// create Criteria
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Solution> criteriaQuery = builder.createQuery(Solution.class);
		Root<Solution> root = criteriaQuery.from(Solution.class);
		criteriaQuery.where(builder.equal(root.get("technologie"), technologie));
		List<Solution> listutil = session.createQuery(criteriaQuery).getResultList();
//        session.close();

		return listutil;
	}

	/*
	 * recupère les solutions liées a un logiciel en passant par l'id du logiciel
	 */
	@Override
	public List<Solution> getByidLogiciel(Long idLogiciel) {
		Session session = sessionFactory.getCurrentSession();

		Logiciel log = Logserv.findById(idLogiciel);
		// create Criteria
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Solution> criteriaQuery = builder.createQuery(Solution.class);
		Root<Solution> root = criteriaQuery.from(Solution.class);
		criteriaQuery.where(builder.equal(root.get("logiciel"), log));
		List<Solution> listutil = session.createQuery(criteriaQuery).getResultList();
//        session.close();

		return listutil;
	}

	/*
	 * recupère les solutions liées a un logiciel
	 */
	@Override
	public List<Solution> getByLogiciel(Logiciel logiciel) {
		Session session = sessionFactory.getCurrentSession();

		// create Criteria
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Solution> criteriaQuery = builder.createQuery(Solution.class);
		Root<Solution> root = criteriaQuery.from(Solution.class);
		criteriaQuery.where(builder.equal(root.get("logiciel"), logiciel));
		List<Solution> listutil = session.createQuery(criteriaQuery).getResultList();
//        session.close();

		return listutil;
	}

	/*
	 * recupère les solutions liées a un utilisateur
	 */
	@Override
	public List<Solution> getByUtilisateur(Utilisateur util) {
		Long id = util.getIdUtilisateur();
		Session session = sessionFactory.getCurrentSession();

		// create Criteria
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Solution> criteriaQuery = builder.createQuery(Solution.class);
		Root<Solution> solroot = criteriaQuery.from(Solution.class);
		Root<Proposition> propidroot = criteriaQuery.from(Proposition.class);
		criteriaQuery.select(solroot); // on sélectionne uniquement les solutions
		
		//la jointure est faite dans la 1ere partie puis on applique la condition sur l'id
		//on doit utiliser propidroot.get("id").get("solutionIdSolution") pour accéder à l'id qui est situé dans PropositionId
		criteriaQuery.where(builder.equal(propidroot.get("id").get("solutionIdSolution"), solroot.get("idSolution")),
				builder.equal(propidroot.get("id").get("utilisateurIdUtilisateur"), id));
		List<Solution> listutil = session.createQuery(criteriaQuery).getResultList();

		return listutil;
	}
}
