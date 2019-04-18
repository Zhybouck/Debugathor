package fr.formation.dao;

import java.util.Date;
import java.util.List;

import fr.formation.entities.Solution;
import fr.formation.entities.Utilisateur;

public interface ISolutionDAO extends IGenericDao<Solution>{

	List<Solution> getByDateInsc(Date debut,Date fin);
}