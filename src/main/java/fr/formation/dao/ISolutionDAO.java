package fr.formation.dao;

import java.util.List;

import fr.formation.entities.Solution;

public interface ISolutionDAO {

	void persist(Solution transientInstance);

	void attachDirty(Solution instance);

	void attachClean(Solution instance);

	void delete(Solution persistentInstance);

	Solution merge(Solution detachedInstance);

	Solution findById(java.lang.Integer id);

	List<Solution> findByExample(Solution instance);

}