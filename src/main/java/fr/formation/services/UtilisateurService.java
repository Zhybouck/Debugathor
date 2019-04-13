package fr.formation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.formation.dao.IUtilisateurDAO;
import fr.formation.dao.UtilisateurDAO;
import fr.formation.entities.Utilisateur;

@Service
@Path("/user")
public class UtilisateurService implements IGenericService<Utilisateur>, IUtilisateurService {
	IUtilisateurDAO utilDao = new UtilisateurDAO();

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
	public Utilisateur findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.formation.services.IUtilisateurService#getAll()
	 */
	@Override
	public List<Utilisateur> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Utilisateur getbyName(@PathParam("Mail")String nom) {
		// TODO Auto-generated method stub
		
		Utilisateur user = utilDao.getByName(nom);
		
		return user;
	}
}
