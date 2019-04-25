package fr.formation.services;

import java.util.List;

import fr.formation.entities.Proposition;
import fr.formation.entities.Solution;
import fr.formation.entities.Utilisateur;

public interface IPropositionService{

	/*
	 * ajoute l'objet obj à la base de données
	 */
	void save(Proposition obj);

	/*
	 * Mets à jout l'objet obj dans la base de données
	 */
	void update(Proposition obj);

	/*
	 * supprime l'objet obj de la base de données
	 */
	void delete(Proposition obj);

	/*
	 *	recupère toute la liste d'objets
	 */
	List<Proposition> getAll();

	/*
	 * recupere toutes les propositions pour un utilisateur
	 */
	List<Proposition> findAllPropbyUser(Utilisateur util);

	/*
	 * recupere toutes les propositions pour une solution
	 */
	List<Proposition> findAllPropbySolution(Solution sol);
}