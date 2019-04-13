package fr.formation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.formation.dao.ILogicielDAO;
import fr.formation.entities.Logiciel;

@Service
public class LogicielService implements ILogicielService {
	ILogicielDAO logDao;
	
	public LogicielService() {
	}



	/* (non-Javadoc)
	 * @see fr.formation.services.ILogicielService#persist(fr.formation.entities.Logiciel)
	 */
	/* (non-Javadoc)
	 * @see fr.formation.services.ILogicielService#persist(fr.formation.entities.Logiciel)
	 */
	@Override
	public void persist(Logiciel transientInstance) {
		logDao.persist(transientInstance);
	}

	/* (non-Javadoc)
	 * @see fr.formation.services.ILogicielService#attachDirty(fr.formation.entities.Logiciel)
	 */
	/* (non-Javadoc)
	 * @see fr.formation.services.ILogicielService#attachDirty(fr.formation.entities.Logiciel)
	 */
	@Override
	public void attachDirty(Logiciel instance) {
		logDao.attachDirty(instance);
		
	}

	/* (non-Javadoc)
	 * @see fr.formation.services.ILogicielService#attachClean(fr.formation.entities.Logiciel)
	 */
	/* (non-Javadoc)
	 * @see fr.formation.services.ILogicielService#attachClean(fr.formation.entities.Logiciel)
	 */
	@Override
	public void attachClean(Logiciel instance) {
		logDao.attachClean(instance);
		
	}

	/* (non-Javadoc)
	 * @see fr.formation.services.ILogicielService#delete(fr.formation.entities.Logiciel)
	 */
	/* (non-Javadoc)
	 * @see fr.formation.services.ILogicielService#delete(fr.formation.entities.Logiciel)
	 */
	@Override
	public void delete(Logiciel persistentInstance) {
		logDao.delete(persistentInstance);
		
	}

	/* (non-Javadoc)
	 * @see fr.formation.services.ILogicielService#merge(fr.formation.entities.Logiciel)
	 */
	/* (non-Javadoc)
	 * @see fr.formation.services.ILogicielService#merge(fr.formation.entities.Logiciel)
	 */
	@Override
	public Logiciel merge(Logiciel detachedInstance) {
		return logDao.merge(detachedInstance);
	}

	/* (non-Javadoc)
	 * @see fr.formation.services.ILogicielService#findById(int)
	 */
	/* (non-Javadoc)
	 * @see fr.formation.services.ILogicielService#findById(int)
	 */
	@Override
	public Logiciel findById(int id) {
		return logDao.findById(id);
	}

	/* (non-Javadoc)
	 * @see fr.formation.services.ILogicielService#findByExample(fr.formation.entities.Logiciel)
	 */
	/* (non-Javadoc)
	 * @see fr.formation.services.ILogicielService#findByExample(fr.formation.entities.Logiciel)
	 */
	@Override
	public List<Logiciel> findByExample(Logiciel instance) {
		return logDao.findByExample(instance);
	}

	/* (non-Javadoc)
	 * @see fr.formation.services.ILogicielService#getAll()
	 */
	/* (non-Javadoc)
	 * @see fr.formation.services.ILogicielService#getAll()
	 */
	@Override
	public List<Logiciel> getAll() {
		return logDao.getAll();
	}




}
