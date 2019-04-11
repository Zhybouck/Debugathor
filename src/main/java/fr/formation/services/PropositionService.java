package fr.formation.services;

import java.util.List;

import fr.formation.dao.IPropositionDAO;
import fr.formation.dao.PropositionDAO;
import fr.formation.entities.Proposition;;

public class PropositionService implements IPropositionService{

	IPropositionDAO propDao=new PropositionDAO();
	
	public PropositionService(IPropositionDAO propDao) {
		this.propDao = propDao;
	}

	/* (non-Javadoc)
	 * @see fr.formation.services.IPropositionService#persist(fr.formation.entities.Proposition)
	 */
	@Override
	public void persist(Proposition transientInstance) {
		propDao.persist(transientInstance);
	}

	/* (non-Javadoc)
	 * @see fr.formation.services.IPropositionService#attachDirty(fr.formation.entities.Proposition)
	 */
	@Override
	public void attachDirty(Proposition instance) {
		propDao.attachDirty(instance);
	}

	/* (non-Javadoc)
	 * @see fr.formation.services.IPropositionService#attachClean(fr.formation.entities.Proposition)
	 */
	@Override
	public void attachClean(Proposition instance) {
		propDao.attachClean(instance);		
	}

	/* (non-Javadoc)
	 * @see fr.formation.services.IPropositionService#delete(fr.formation.entities.Proposition)
	 */
	@Override
	public void delete(Proposition persistentInstance) {
		propDao.delete(persistentInstance);
	}

	/* (non-Javadoc)
	 * @see fr.formation.services.IPropositionService#merge(fr.formation.entities.Proposition)
	 */
	@Override
	public Proposition merge(Proposition detachedInstance) {
		return propDao.merge(detachedInstance);
	}

	/* (non-Javadoc)
	 * @see fr.formation.services.IPropositionService#findById(int)
	 */
	@Override
	public Proposition findById(int id) {
		return propDao.findById(id);
	}

	/* (non-Javadoc)
	 * @see fr.formation.services.IPropositionService#findByExample(fr.formation.entities.Proposition)
	 */
	@Override
	public List<Proposition> findByExample(Proposition instance) {
		return propDao.findByExample(instance);
	}

	/* (non-Javadoc)
	 * @see fr.formation.services.IPropositionService#getAll()
	 */
	@Override
	public List<Proposition> getAll() {
		return propDao.getAll();
	}


}
