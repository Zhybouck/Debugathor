package fr.formation.services;

import java.util.Date;
import java.util.List;

import fr.formation.entities.Solution;

public interface ISolutionService extends IGenericService<Solution>{

	List<Solution> getByDateInsc(Date debut,Date fin);
}