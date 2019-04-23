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

	/*
	 * recupere un utilisateur en utilisant le mail
	 */
	@Override
	public Utilisateur getbyMail(String mail) {
		Session session = sessionFactory.getCurrentSession();

        // create Criteria
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Utilisateur> criteriaQuery = builder.createQuery(Utilisateur.class);
        Root<Utilisateur> root = criteriaQuery.from(Utilisateur.class);
        CriteriaQuery<Utilisateur> select = criteriaQuery.select(root);
        criteriaQuery.where(builder.equal(root.get("mail"), mail));
        Utilisateur util  = session.createQuery(criteriaQuery).getSingleResult();
//        session.close();

        return util;
	}
	
	/*
	 * méthode qui récupère les utilisateurs dont la date d'inscription est comprise entre deux dates
	 */
	@Override
	public List<Utilisateur> getByDateInsc(Date debut,Date fin){
		Session session = sessionFactory.getCurrentSession();
		
		//on passe du format java au format sql pour les dates
		java.sql.Date debutsql=new java.sql.Date(debut.getTime());
		java.sql.Date finsql=new java.sql.Date(fin.getTime());
		
        // create Criteria
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Utilisateur> criteriaQuery = builder.createQuery(Utilisateur.class);
        Root<Utilisateur> root = criteriaQuery.from(Utilisateur.class);
        criteriaQuery.where(builder.between(root.get("dateInsc"), debutsql, finsql));
        List<Utilisateur> listutil  = session.createQuery(criteriaQuery).getResultList();
//        session.close();

        return listutil;
		
	}
	
	/*
	 * recupère tous les utilisateurs d'un certain rang
	 */
	@Override
	public List<Utilisateur> getbyRank(String rank) {
		Session session = sessionFactory.getCurrentSession();

        // create Criteria
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Utilisateur> criteriaQuery = builder.createQuery(Utilisateur.class);
        Root<Utilisateur> root = criteriaQuery.from(Utilisateur.class);
        CriteriaQuery<Utilisateur> select = criteriaQuery.select(root);
        criteriaQuery.where(builder.equal(root.get("rang"), rank));
        List<Utilisateur> list  = session.createQuery(criteriaQuery).getResultList();
//        session.close();

        return list;
	}
	
	/*
	 * récupère tous les utilisateurs à un certain poste
	 */
	@Override
	public List<Utilisateur> getbyPoste(String poste) {
		Session session = sessionFactory.getCurrentSession();

        // create Criteria
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Utilisateur> criteriaQuery = builder.createQuery(Utilisateur.class);
        Root<Utilisateur> root = criteriaQuery.from(Utilisateur.class);
        CriteriaQuery<Utilisateur> select = criteriaQuery.select(root);
        criteriaQuery.where(builder.equal(root.get("poste"),poste));
        List<Utilisateur> list  = session.createQuery(criteriaQuery).getResultList();
//        session.close();

        return list;
	}
	
	/*
	 * recupere tous les utilisateurs àyant un certain nom
	 */
	@Override
	public List<Utilisateur> getbyLastName(String name) {
		Session session = sessionFactory.getCurrentSession();

        // create Criteria
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Utilisateur> criteriaQuery = builder.createQuery(Utilisateur.class);
        Root<Utilisateur> root = criteriaQuery.from(Utilisateur.class);
        CriteriaQuery<Utilisateur> select = criteriaQuery.select(root);
        criteriaQuery.where(builder.like(root.get("nom"),"%"+name+"%"));
        List<Utilisateur> list  = session.createQuery(criteriaQuery).getResultList();
//        session.close();

        return list;
	}
	
	
	/*
	 * recupere tous les utilisateurs ayant un certain prénom
	 */
	@Override
	public List<Utilisateur> getbyFirstName(String name) {
		Session session = sessionFactory.getCurrentSession();

        // create Criteria
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Utilisateur> criteriaQuery = builder.createQuery(Utilisateur.class);
        Root<Utilisateur> root = criteriaQuery.from(Utilisateur.class);
        CriteriaQuery<Utilisateur> select = criteriaQuery.select(root);
        criteriaQuery.where(builder.like(root.get("prenom"),"%"+name+"%"));
        List<Utilisateur> list  = session.createQuery(criteriaQuery).getResultList();
//        session.close();

        return list;
	}
}
