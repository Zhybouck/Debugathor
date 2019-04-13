package fr.formation.dao;

import fr.formation.entities.Utilisateur;

public interface IUtilisateurDAO extends IGenericDAO<Utilisateur>{
	Utilisateur getByMail(String mail);

}