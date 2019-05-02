package fr.formation.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.formation.dao.ISolutionDAO;
import fr.formation.entities.Logiciel;
import fr.formation.entities.Solution;
import fr.formation.entities.Utilisateur;

@Service
public class SolutionService implements ISolutionService{

	@Autowired
	@Qualifier(value="solutionDao")
	ISolutionDAO solDao;
	
	@Override
	public void save(Solution obj) {
		solDao.save(obj);
		
	}

	@Override
	public void update(Solution obj) {
		solDao.update(obj);
		
	}

	@Override
	public void delete(Solution obj) {
		solDao.delete(obj);
		
	}

	@Override
	public Solution findById(Long empId) {
		return solDao.findById(empId);
	}
	
	/* (non-Javadoc)
	 * @see fr.formation.services.ILogicielService#getAll()
	 */
	@Override
	public List<Solution> getAll() {
		return solDao.getAll();
	}

	@Override
	public List<Solution> getByDateBug(Date debut, Date fin) {
		return solDao.getByDateBug(debut, fin);
	}

	@Override
	public List<Solution> getByTitre(String titre) {
		return solDao.getByTitre(titre);
	}
	
	/*
	 * recupère une liste de solutions en fonction de la technologie associée
	 */
	@Override
	public List<Solution> getByTechno(String technologie) {
		return solDao.getByTechno(technologie);
	}

	/*
	 * récupère une liste de solutions en fonction de l'id du logiciel
	 */
	@Override
	public List<Solution> getByidLogiciel(Long idLogiciel) {
		return solDao.getByidLogiciel(idLogiciel);
	}

	/*
	 * récupère une liste de solutions en fonction du logiciel
	 */
	@Override
	public List<Solution> getByLogiciel(Logiciel logiciel) {
		return solDao.getByLogiciel(logiciel);
	}

	/*
	 * recupère les solutions CRÉÉES par un certain utilisateur
	 */
	@Override
	public List<Solution> getByUtilisateur(Utilisateur util) {
		return solDao.getByUtilisateur(util);
	}
}
