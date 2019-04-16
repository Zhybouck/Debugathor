package fr.formation.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class GenericDAO<T> {
	private Class<T> clazz;
	private static final Log log = LogFactory.getLog(GenericDAO.class);

	@Autowired
	SessionFactory sessionFactory;

	/*
	 * ajoute l'objet obj à la base de données
	 */
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
	 *	recupère toute la liste d'objets
	 */
	public List<T> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery( "from " + clazz.getName() ).list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.formation.inti.dao.IEmployeeDAO#findById(java.lang.Long)
	 */
	public T findById(Long empId) {
		Session session = sessionFactory.getCurrentSession();
		T emp = null;

		try {
			emp = session.get(clazz, empId);
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return emp;
	}
}
