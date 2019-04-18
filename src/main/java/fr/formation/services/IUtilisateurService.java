package fr.formation.services;

import java.util.Date;
import java.util.List;

import fr.formation.entities.Utilisateur;

public interface IUtilisateurService extends IGenericService<Utilisateur> {

	Utilisateur getbyMail(String mail);

	List<Utilisateur> getByDateInsc(Date debut,Date fin);

}