package fr.formation.services;

import java.util.List;

import fr.formation.dao.ISolutionDAO;
import fr.formation.dao.SolutionDAO;
import fr.formation.entities.Solution;

public class SolutionService implements ISolutionService{
	ISolutionDAO solDao= new SolutionDAO();
	
	public SolutionService(ISolutionDAO solDao) {
		this.solDao = solDao;
	}

	/* (non-Javadoc)
	 * @see fr.formation.services.ISolutionService#persist(fr.formation.entities.Solution)
	 */
	@Override
	public void persist(Solution transientInstance) {
		solDao.persist(transientInstance);
		
	}

	/* (non-Javadoc)
	 * @see fr.formation.services.ISolutionService#attachDirty(fr.formation.entities.Solution)
	 */
	@Override
	public void attachDirty(Solution instance) {
		solDao.attachDirty(instance);
	}

	/* (non-Javadoc)
	 * @see fr.formation.services.ISolutionService#attachClean(fr.formation.entities.Solution)
	 */
	@Override
	public void attachClean(Solution instance) {
		solDao.attachClean(instance);
	}

	/* (non-Javadoc)
	 * @see fr.formation.services.ISolutionService#delete(fr.formation.entities.Solution)
	 */
	@Override
	public void delete(Solution persistentInstance) {
		solDao.delete(persistentInstance);
	}

	/* (non-Javadoc)
	 * @see fr.formation.services.ISolutionService#merge(fr.formation.entities.Solution)
	 */
	@Override
	public Solution merge(Solution detachedInstance) {
		return solDao.merge(detachedInstance);
	}

	/* (non-Javadoc)
	 * @see fr.formation.services.ISolutionService#findById(int)
	 */
	@Override
	public Solution findById(int id) {
		return solDao.findById(id);
	}

	/* (non-Javadoc)
	 * @see fr.formation.services.ISolutionService#findByExample(fr.formation.entities.Solution)
	 */
	@Override
	public List<Solution> findByExample(Solution instance) {
		return solDao.findByExample(instance);
	}

	/* (non-Javadoc)
	 * @see fr.formation.services.ISolutionService#getAll()
	 */
	@Override
	public List<Solution> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
