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

import fr.formation.entities.Logiciel;
import fr.formation.entities.Solution;

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

	/*
	 * recupère une liste de logiciel par rapport à son nom (toutes les versions d'eclipse par exemple)
	 */
	@Override
	public List<Logiciel> findByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		
        // create Criteria
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Logiciel> criteriaQuery = builder.createQuery(Logiciel.class);
        Root<Logiciel> root = criteriaQuery.from(Logiciel.class);
        criteriaQuery.where(builder.like(root.get("nomLogiciel"), "%"+name+"%"));
        List<Logiciel> listutil  = session.createQuery(criteriaQuery).getResultList();
//        session.close();

        return listutil;
	}
}
