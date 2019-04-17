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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Utilisateur obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Utilisateur obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur findById(Long empId) {
		// TODO Auto-generated method stub
		return null;
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
