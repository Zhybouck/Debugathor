package fr.formation.dao;

import java.util.Date;
import java.util.List;

import fr.formation.entities.Utilisateur;

public interface IUtilisateurDAO extends IGenericDao<Utilisateur> {

	Utilisateur getbyMail(String mail);

	List<Utilisateur> getByDateInsc(Date debut, Date fin);

	List<Utilisateur> getbyRank(String rank);

	List<Utilisateur> getbyPoste(String poste);

	List<Utilisateur> getbyFirstName(String name);

	List<Utilisateur> getbyLastName(String name);
}