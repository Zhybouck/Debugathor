package fr.formation.services;

import java.util.List;

import org.springframework.stereotype.Service;


import fr.formation.dao.IUtilisateurDAO;
import fr.formation.dao.UtilisateurDAO;
import fr.formation.entities.Utilisateur;

@Service
public class UtilisateurService implements IGenericService<Utilisateur>, IUtilisateurService {
	IUtilisateurDAO utilDao = new UtilisateurDAO();
	int test;

	public UtilisateurService(IUtilisateurDAO utilisateurDao) {
		utilDao = utilisateurDao;
	}

	public UtilisateurService() {
	}

	/* (non-Javadoc)
	 * @see fr.formation.services.IUtilisateurService#persist(fr.formation.entities.Utilisateur)
	 */
	/* (non-Javadoc)
	 * @see fr.formation.services.IUtilisateurService#persist(fr.formation.entities.Utilisateur)
	 */
	@Override
	public void persist(Utilisateur transientInstance) {
		utilDao.persist(transientInstance);

	}

	/* (non-Javadoc)
	 * @see fr.formation.services.IUtilisateurService#merge(fr.formation.entities.Utilisateur)
	 */
	/* (non-Javadoc)
	 * @see fr.formation.services.IUtilisateurService#merge(fr.formation.entities.Utilisateur)
	 */
	@Override
	public Utilisateur merge(Utilisateur detachedInstance) {
		return utilDao.merge(detachedInstance);
	}

	/* (non-Javadoc)
	 * @see fr.formation.services.IUtilisateurService#findById(java.lang.Integer)
	 */

	/* (non-Javadoc)
	 * @see fr.formation.services.IUtilisateurService#findByExample(fr.formation.entities.Utilisateur)
	 */
	/* (non-Javadoc)
	 * @see fr.formation.services.IUtilisateurService#findByExample(fr.formation.entities.Utilisateur)
	 */
	@Override
	public List<Utilisateur> findByExample(Utilisateur instance) {
		return utilDao.findByExample(instance);
	}

	/* (non-Javadoc)
	 * @see fr.formation.services.IUtilisateurService#delete(fr.formation.entities.Utilisateur)
	 */
	/* (non-Javadoc)
	 * @see fr.formation.services.IUtilisateurService#delete(fr.formation.entities.Utilisateur)
	 */
	@Override
	public void delete(Utilisateur persistentInstance) {
		utilDao.delete(persistentInstance);

	}

	/* (non-Javadoc)
	 * @see fr.formation.services.IUtilisateurService#attachDirty(fr.formation.entities.Utilisateur)
	 */
	/* (non-Javadoc)
	 * @see fr.formation.services.IUtilisateurService#attachDirty(fr.formation.entities.Utilisateur)
	 */
	@Override
	public void attachDirty(Utilisateur instance) {
		utilDao.attachDirty(instance);

	}

	/* (non-Javadoc)
	 * @see fr.formation.services.IUtilisateurService#attachClean(fr.formation.entities.Utilisateur)
	 */
	/* (non-Javadoc)
	 * @see fr.formation.services.IUtilisateurService#attachClean(fr.formation.entities.Utilisateur)
	 */
	@Override
	public void attachClean(Utilisateur instance) {
		utilDao.attachClean(instance);

	}

	/* (non-Javadoc)
	 * @see fr.formation.services.IUtilisateurService#findById(int)
	 */
	@Override
	public Utilisateur findById(Integer id) {
		Utilisateur user = utilDao.findById(id);
		return user;
	}

	/* (non-Javadoc)
	 * @see fr.formation.services.IUtilisateurService#getAll()
	 */
	@Override
	public List<Utilisateur> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Utilisateur getbyMail(String mail) {
		Utilisateur user = utilDao.getByMail(mail);
		return user;
	}
}
