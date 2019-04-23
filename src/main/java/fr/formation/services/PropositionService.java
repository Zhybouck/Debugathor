package fr.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.formation.dao.IPropositionDAO;
import fr.formation.entities.Proposition;
import fr.formation.entities.Solution;
import fr.formation.entities.Utilisateur;;

@Service
public class PropositionService implements IPropositionService{

	@Autowired
	@Qualifier(value="propositionDao")
	IPropositionDAO propDao;
	
	public PropositionService() {
	
	}

	@Override
	public void save(Proposition obj) {
		propDao.save(obj);
		
	}

	@Override
	public void update(Proposition obj) {
		propDao.update(obj);
		
	}

	@Override
	public void delete(Proposition obj) {
		propDao.delete(obj);
		
	}

	@Override
	public Proposition findById(Long empId) {
		return propDao.findById(empId);
	}
	
	/* (non-Javadoc)
	 * @see fr.formation.services.ILogicielService#getAll()
	 */
	@Override
	public List<Proposition> getAll() {
		return propDao.getAll();
	}

	@Override
	public List<Proposition> findAllPropbyUser(Utilisateur util) {
		return propDao.findAllPropbyUser(util);
	}

	@Override
	public List<Proposition> findAllPropbySolution(Solution sol) {
		return propDao.findAllPropbySolution(sol);
	}

	


}
