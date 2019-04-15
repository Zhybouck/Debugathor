package fr.formation.dao;

import java.util.List;

import fr.formation.entities.Logiciel;

public interface ILogicielDAO extends IGenericDAO<Logiciel>{

	List<Logiciel> findByName(String name);
	
}