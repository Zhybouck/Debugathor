package fr.formation.services;

import java.util.List;

import fr.formation.dao.IPropositionDAO;
import fr.formation.dao.PropositionDAO;
import fr.formation.entities.Proposition;;

public class PropositionService implements IGenericService<Proposition>{

	IPropositionDAO propDao=new PropositionDAO();
	
	public PropositionService(IPropositionDAO propDao) {
		this.propDao = propDao;
	}

	@Override
	public void persist(Proposition transientInstance) {
		propDao.persist(transientInstance);
	}

	@Override
	public void attachDirty(Proposition instance) {
		propDao.attachDirty(instance);
	}

	@Override
	public void attachClean(Proposition instance) {
		propDao.attachClean(instance);		
	}

	@Override
	public void delete(Proposition persistentInstance) {
		propDao.delete(persistentInstance);
	}

	@Override
	public Proposition merge(Proposition detachedInstance) {
		return propDao.merge(detachedInstance);
	}

	@Override
	public Proposition findById(int id) {
		return propDao.findById(id);
	}

	@Override
	public List<Proposition> findByExample(Proposition instance) {
		return propDao.findByExample(instance);
	}

	@Override
	public List<Proposition> getAll() {
		return propDao.getAll();
	}


}
