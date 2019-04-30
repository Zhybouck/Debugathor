package fr.formation.services;

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
import fr.formation.entities.Solution;
import fr.formation.entities.Utilisateur;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { ApplicationContextConfig.class, SpringWebAppInitializer.class })
@Transactional
public class PropositionServiceTest {

	@Autowired
	private IPropositionService propositionService;
	
	@Autowired
	private ISolutionService solutionService;
	
	@Autowired
	private IUtilisateurService UtilisateurService;
	
	@Test
	@Rollback(true)
	public void saveProposition() {
		Proposition prop = new Proposition();
		Solution s = solutionService.findById(2l);
		Utilisateur u = UtilisateurService.findById(3l);
		prop.setSolution(s);
		prop.setUtilisateur(u);
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
		List<Proposition> props=propositionService.getAll();
		int sizeoftable=props.size();
		propositionService.save(prop);
		props=propositionService.getAll();
		
		assertEquals(props.size(),sizeoftable+1);
	}
	
	@Test
	@Rollback(true)
	public void updateProposition() {
		Solution sol = solutionService.findById(1l);
		List<Proposition> props = propositionService.findAllPropbySolution(sol);
		Proposition prop= props.get(0);
		prop.setCommentaire("on a update le commentaire");
		props=propositionService.getAll();
		int sizeoftable=props.size();
		propositionService.update(prop);
		props=propositionService.getAll();
		
		assertEquals(props.size(),sizeoftable);
		assertEquals(props.get(0).getCommentaire(),"on a update le commentaire");
	}
	
	@Test
	@Rollback(true)
	public void deleteProposition() {
		Solution s = solutionService.findById(2l);
		Proposition prop = propositionService.findAllPropbySolution(s).get(0);
		List<Proposition> props=propositionService.getAll();
		int sizeoftable=props.size();
		propositionService.delete(prop);
		props=propositionService.getAll();
		assertEquals(props.size(),sizeoftable-1);
	}
}
