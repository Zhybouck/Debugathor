package fr.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.formation.dao.ILogicielDAO;
import fr.formation.entities.Logiciel;

@Service
public class LogicielService implements ILogicielService{
	@Autowired
	@Qualifier(value="logicielDao")
	ILogicielDAO logDao;
	
	public LogicielService() {
	}



	/* (non-Javadoc)
	 * @see fr.formation.services.ILogicielService#getAll()
	 */
	/* (non-Javadoc)
	 * @see fr.formation.services.ILogicielService#getAll()
	 */
	public List<Logiciel> getAll() {
		return logDao.getAll();
	}



	@Override
	public void persist(Logiciel transientInstance) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void attachDirty(Logiciel instance) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void attachClean(Logiciel instance) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void delete(Logiciel persistentInstance) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Logiciel merge(Logiciel detachedInstance) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Logiciel findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Logiciel> findByExample(Logiciel instance) {
		// TODO Auto-generated method stub
		return null;
	}






}
