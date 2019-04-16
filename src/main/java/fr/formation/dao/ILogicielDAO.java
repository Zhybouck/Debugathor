package fr.formation.dao;

import java.util.List;

import fr.formation.entities.Logiciel;

public interface ILogicielDAO extends IGenericDao<Logiciel>{

	List<Logiciel> findByName(String name);
	
}