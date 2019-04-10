package fr.formation.services;

import java.util.List;

import fr.formation.dao.ISolutionDAO;
import fr.formation.dao.SolutionDAO;
import fr.formation.entities.Solution;

public class SolutionService implements IGenericService<Solution>{
	ISolutionDAO solDao= new SolutionDAO();
	
	public SolutionService(ISolutionDAO solDao) {
		this.solDao = solDao;
	}

	@Override
	public void persist(Solution transientInstance) {
		solDao.persist(transientInstance);
		
	}

	@Override
	public void attachDirty(Solution instance) {
		solDao.attachDirty(instance);
	}

	@Override
	public void attachClean(Solution instance) {
		solDao.attachClean(instance);
	}

	@Override
	public void delete(Solution persistentInstance) {
		solDao.delete(persistentInstance);
	}

	@Override
	public Solution merge(Solution detachedInstance) {
		return solDao.merge(detachedInstance);
	}

	@Override
	public Solution findById(int id) {
		return solDao.findById(id);
	}

	@Override
	public List<Solution> findByExample(Solution instance) {
		return solDao.findByExample(instance);
	}

	@Override
	public List<Solution> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
