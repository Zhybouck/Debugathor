package fr.formation.dao;

import java.util.List;

import fr.formation.entities.Proposition;
import fr.formation.entities.Solution;
import fr.formation.entities.Utilisateur;

// on ne peut pas utiliser igeneric car 
// il n'est pas possible de récuperer une proposition avec un ID unique
// propisition ne possède pas de clé primaire
public interface IPropositionDAO {

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
	 * recupère toute la liste d'objets
	 */
	List<Proposition> getAll();

	/*
	 * renvoie toutes les propositions pour un utilisateur
	 */
	List<Proposition> findAllPropbyUser(Utilisateur util);

	/*
	 * renvoie toutes les propositions pour une solution
	 */
	List<Proposition> findAllPropbySolution(Solution sol);
}