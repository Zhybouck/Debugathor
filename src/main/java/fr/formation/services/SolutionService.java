package fr.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.formation.dao.ISolutionDAO;
import fr.formation.entities.Solution;

@Service
public class SolutionService implements ISolutionService{

	@Autowired
	@Qualifier(value="solutionDao")
	ISolutionDAO solDao;
	
	@Override
	public void save(Solution obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Solution obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Solution obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Solution findById(Long empId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see fr.formation.services.ILogicielService#getAll()
	 */
	@Override
	public List<Solution> getAll() {
		return solDao.getAll();
	}
}
