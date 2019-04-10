package fr.formation.dao;

import java.util.List;

import fr.formation.entities.Utilisateur;

public interface IUtilisateurDAO {

	void persist(Utilisateur transientInstance);

	void attachDirty(Utilisateur instance);

	void attachClean(Utilisateur instance);

	void delete(Utilisateur persistentInstance);

	Utilisateur merge(Utilisateur detachedInstance);

	Utilisateur findById(java.lang.Integer id);

	List<Utilisateur> findByExample(Utilisateur instance);

}