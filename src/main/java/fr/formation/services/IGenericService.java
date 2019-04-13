package fr.formation.services;

import java.util.List;

public interface IGenericService<T> {

	void persist(T transientInstance);

	void attachDirty(T instance);

	void attachClean(T instance);

	void delete(T persistentInstance);

	T merge(T detachedInstance);

	T findById(Integer id);

	List<T> findByExample(T instance);

	List<T> getAll();
	
}
