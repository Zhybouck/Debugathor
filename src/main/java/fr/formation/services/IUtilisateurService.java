package fr.formation.services;

import fr.formation.entities.Utilisateur;

public interface IUtilisateurService extends IGenericService<Utilisateur>{

	Utilisateur getbyMail(String mail);

}