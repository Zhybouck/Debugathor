package fr.formation.services;

import java.util.List;

import fr.formation.entities.Proposition;
import fr.formation.entities.Solution;
import fr.formation.entities.Utilisateur;

public interface IPropositionService extends IGenericService<Proposition>{

	List<Proposition> findAllPropbyUser(Utilisateur util);

	List<Proposition> findAllPropbySolution(Solution sol);
}