package fr.formation.services;

import java.util.Date;
import java.util.List;

import fr.formation.entities.Logiciel;
import fr.formation.entities.Solution;
import fr.formation.entities.Utilisateur;

public interface ISolutionService extends IGenericService<Solution>{

	List<Solution> getByDateBug(Date debut,Date fin);
	
	List<Solution> getByTitre(String titre);
	
	List<Solution> getByTechno(String technologie);

	List<Solution> getByidLogiciel(Long idLogiciel);

	List<Solution> getByLogiciel(Logiciel logiciel);
	
	List<Solution> getByUtilisateur(Utilisateur util);
	
}