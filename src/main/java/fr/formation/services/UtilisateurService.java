package fr.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.formation.dao.IUtilisateurDAO;
import fr.formation.entities.Utilisateur;

@Service
public class UtilisateurService implements IGenericService<Utilisateur>, IUtilisateurService {

	@Autowired
	@Qualifier(value="utilisateurDao")
	IUtilisateurDAO utilDao;
	
	public UtilisateurService() {

	}
	
	
	@Override
	public void save(Utilisateur obj) {
		utilDao.save(obj);
	}

	@Override
	public void update(Utilisateur obj) {
		utilDao.update(obj);
		
	}

	@Override
	public void delete(Utilisateur obj) {
		utilDao.delete(obj);	
	}

	@Override
	public Utilisateur findById(Long empId) {
		return utilDao.findById(empId);
	}
	
	/* (non-Javadoc)
	 * @see fr.formation.services.ILogicielService#getAll()
	 */
	@Override
	public List<Utilisateur> getAll() {
		return utilDao.getAll();
	}


	@Override
	public Utilisateur getbyMail(String mail) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
