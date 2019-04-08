package fr.formation.dao;

import java.util.List;

import org.hibernate.Session;

import fr.formation.beans.Logiciel;

public interface ILogicielDAO {

	/* (non-Javadoc)
	 * @see fr.formation.dao.ISolutionDAO#persist(fr.formation.beans.Logiciel)
	 */
	void persist(Logiciel transientInstance);

	/* (non-Javadoc)
	 * @see fr.formation.dao.ISolutionDAO#attachDirty(fr.formation.beans.Logiciel)
	 */
	void attachDirty(Logiciel instance);

	/* (non-Javadoc)
	 * @see fr.formation.dao.ISolutionDAO#attachClean(fr.formation.beans.Logiciel)
	 */
	void attachClean(Logiciel instance);

	/* (non-Javadoc)
	 * @see fr.formation.dao.ISolutionDAO#delete(fr.formation.beans.Logiciel)
	 */
	void delete(Logiciel persistentInstance);

	/* (non-Javadoc)
	 * @see fr.formation.dao.ISolutionDAO#merge(fr.formation.beans.Logiciel)
	 */
	Logiciel merge(Logiciel detachedInstance);

	/* (non-Javadoc)
	 * @see fr.formation.dao.ISolutionDAO#findById(int)
	 */
	Logiciel findById(int id);

	/* (non-Javadoc)
	 * @see fr.formation.dao.ISolutionDAO#findByExample(fr.formation.beans.Logiciel)
	 */
	List<Logiciel> findByExample(Logiciel instance);
	List<Logiciel> getAll();
}