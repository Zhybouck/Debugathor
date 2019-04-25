package fr.formation.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericDAO<T extends Serializable> implements IGenericDao<T> {
	private Class<T> clazz;
	private static final Log log = LogFactory.getLog(GenericDAO.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.formation.dao.IGenericDao#setClazz(java.lang.Class)
	 */

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Autowired
	SessionFactory sessionFactory;

	/*
	 * ajoute l'objet obj à la base de données
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.formation.dao.IGenericDao#save(T)
	 */
	@Override
	public void save(T obj) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.persist(obj);
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	/*
	 * Mets à jout l'objet obj dans la base de données
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.formation.dao.IGenericDao#update(T)
	 */
	@Override
	public void update(T obj) {
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
	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.formation.dao.IGenericDao#delete(T)
	 */
	@Override
	public void delete(T obj) {
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
	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.formation.dao.IGenericDao#getAll()
	 */
	@Override
	public List<T> getAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaQuery<T> criteria = session.getCriteriaBuilder().createQuery(clazz);
		criteria.select(criteria.from(clazz));
		return session.createQuery(criteria).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.formation.inti.dao.IEmployeeDAO#findById(java.lang.Long)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.formation.dao.IGenericDao#findById(java.lang.Long)
	 */
	@Override
	public T findById(Long Id) {
		Session session = sessionFactory.getCurrentSession();
		T emp = null;

		try {
			emp = session.get(clazz,Id);
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return emp;
	}
}
