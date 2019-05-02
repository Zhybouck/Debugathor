package fr.formation.services;

import java.util.Date;
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
	
	@Override
	public List<Utilisateur> getAll() {
		return utilDao.getAll();
	}

	/*
	 * recupère un utilisateur par son mail
	 */
	@Override
	public Utilisateur getbyMail(String mail) {
		return utilDao.getbyMail(mail);
	}

	/*
	 * recupère un utilisateur inscrit entre deux dates
	 */
	@Override
	public List<Utilisateur> getByDateInsc(Date debut, Date fin) {
		return utilDao.getByDateInsc(debut, fin);
	}

	/*
	 * recupère un utilisateur par son rang
	 */
	@Override
	public List<Utilisateur> getbyRank(String rank) {
		return utilDao.getbyRank(rank);
	}

	/*
	 * recupère un utilisateur par son poste
	 */
	@Override
	public List<Utilisateur> getbyPoste(String poste) {
		return utilDao.getbyPoste(poste);
	}

	/*
	 * recupère un utilisateur par son prénom
	 */
	@Override
	public List<Utilisateur> getbyFirstName(String name) {
		return utilDao.getbyFirstName(name);
	}

	/*
	 * recupère un utilisateur par son nom
	 */
	@Override
	public List<Utilisateur> getbyLastName(String name) {
		return utilDao.getbyLastName(name);
	}
	
}
