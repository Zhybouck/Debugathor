package fr.formation.services;

import java.util.List;

import fr.formation.entities.Logiciel;

public interface ILogicielService extends IGenericService<Logiciel>{

	List<Logiciel> findByName(String name);
}