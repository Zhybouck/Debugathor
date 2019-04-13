package fr.formation.dao;

import java.util.List;

public interface IGenericDAO<T> {

	void persist(T transientInstance);

	void attachDirty(T instance);

	void attachClean(T instance);

	void delete(T persistentInstance);

	T merge(T detachedInstance);

	T findById(int id);

	List<T> findByExample(T instance);

	List<T> getAll();
	
	T getByName(String nom);
}
