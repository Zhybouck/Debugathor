package fr.formation.dao;

import java.util.List;

import fr.formation.beans.Proposition;

public interface IPropositionDAO {

	void persist(Proposition transientInstance);

	void attachDirty(Proposition instance);

	void attachClean(Proposition instance);

	void delete(Proposition persistentInstance);

	Proposition merge(Proposition detachedInstance);

	Proposition findById(int id);

	List<Proposition> findByExample(Proposition instance);

}