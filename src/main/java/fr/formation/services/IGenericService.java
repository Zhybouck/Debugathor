package fr.formation.services;

import java.util.List;

public interface IGenericService<T> {

	/*
	 * ajoute l'objet obj à la base de données
	 */
	void save(T obj);

	/*
	 * Mets à jout l'objet obj dans la base de données
	 */
	void update(T obj);

	/*
	 * supprime l'objet obj de la base de données
	 */
	void delete(T obj);

	/*
	 *	recupère toute la liste d'objets
	 */
	List<T> getAll();

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.formation.inti.dao.IEmployeeDAO#findById(java.lang.Long)
	 */
	T findById(Long empId);
	
}
