package fr.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.IPropositionDAO;
import fr.formation.entities.Proposition;;


public class PropositionService implements IPropositionService{

	@Autowired
	IPropositionDAO propDao;
	
	
	
	public PropositionService() {
	}

	public PropositionService(IPropositionDAO propDao) {
		this.propDao = propDao;
	}

	@Override
	public void persist(Proposition transientInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachDirty(Proposition instance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachClean(Proposition instance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Proposition persistentInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Proposition merge(Proposition detachedInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proposition findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proposition> findByExample(Proposition instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proposition> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	


}
