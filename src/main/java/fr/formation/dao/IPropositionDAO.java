package fr.formation.dao;

import java.util.List;

import fr.formation.entities.Proposition;
import fr.formation.entities.Utilisateur;

public interface IPropositionDAO extends IGenericDao<Proposition> {
	List<Proposition> findAllPropbyUser(Utilisateur util);
}