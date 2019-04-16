package fr.formation.dao;

import fr.formation.entities.Utilisateur;

public interface IUtilisateurDAO extends IGenericDao<Utilisateur>{
	Utilisateur getByMail(String mail);

}