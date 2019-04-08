package fr.formation.dao;

import java.util.List;

import fr.formation.beans.Logiciel;

public interface ISolutionDAO {

	void persist(Logiciel transientInstance);

	void attachDirty(Logiciel instance);

	void attachClean(Logiciel instance);

	void delete(Logiciel persistentInstance);

	Logiciel merge(Logiciel detachedInstance);

	Logiciel findById(int id);

	List<Logiciel> findByExample(Logiciel instance);

}