package fr.formation.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.config.ApplicationContextConfig;
import fr.formation.config.SpringWebAppInitializer;
import fr.formation.entities.Proposition;
import fr.formation.entities.PropositionId;
import fr.formation.entities.Solution;
import fr.formation.entities.Utilisateur;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { ApplicationContextConfig.class, SpringWebAppInitializer.class })
@Transactional
public class PropositionDAOTest {

	@Autowired
	private IPropositionDAO propositionDAO;
	
	@Autowired
	private ISolutionDAO solutionDAO;
	
	@Autowired
	private IUtilisateurDAO UtilisateurDAO;
	
	@Test
	@Rollback(true)
	public void saveProposition() {
		Proposition prop = new Proposition();
		PropositionId propid=new PropositionId();
		Solution s = solutionDAO.findById(2l);
		Utilisateur u = UtilisateurDAO.findById(3l);
		prop.setSolution(s);
		prop.setUtilisateur(u);
		propid.setSolutionIdSolution(2l);
		propid.setUtilisateurIdUtilisateur(3l);
		prop.setId(propid);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date datejava=null;
		try {
			datejava = simpleDateFormat.parse("2014/11/11");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date = new Date(datejava.getTime());
		prop.setDateProp(date);
		prop.setCommentaire("ceci est un commentaire");
		prop.setNote(5);
		List<Proposition> props=propositionDAO.getAll();
		int sizeoftable=props.size();
		propositionDAO.save(prop);
		props=propositionDAO.getAll();
		
		assertEquals(props.size(),sizeoftable+1);
	}
	
	@Test
	@Rollback(true)
	public void updateProposition() {
		Solution sol = solutionDAO.findById(1l);
		List<Proposition> props = propositionDAO.findAllPropbySolution(sol);
		Proposition prop= props.get(0);
		prop.setCommentaire("on a update le commentaire");
		props=propositionDAO.getAll();
		int sizeoftable=props.size();
		propositionDAO.update(prop);
		props=propositionDAO.getAll();
		
		assertEquals(props.size(),sizeoftable);
		assertEquals(props.get(0).getCommentaire(),"on a update le commentaire");
	}
	
	@Test
	@Rollback(true)
	public void deleteProposition() {
		Solution s = solutionDAO.findById(2l);
		Proposition prop = propositionDAO.findAllPropbySolution(s).get(0);
		List<Proposition> props=propositionDAO.getAll();
		int sizeoftable=props.size();
		propositionDAO.delete(prop);
		props=propositionDAO.getAll();
		assertEquals(props.size(),sizeoftable-1);
	}
}
