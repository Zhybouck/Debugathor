package fr.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.formation.dao.IPropositionDAO;
import fr.formation.entities.Proposition;;

@Service
public class PropositionService implements IPropositionService{

	@Autowired
	@Qualifier(value="propositionDao")
	IPropositionDAO propDao;
	
	public PropositionService() {
	
	}

	@Override
	public void save(Proposition obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Proposition obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Proposition obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Proposition findById(Long empId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see fr.formation.services.ILogicielService#getAll()
	 */
	@Override
	public List<Proposition> getAll() {
		return propDao.getAll();
	}

	


}
