package fr.formation.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
import fr.formation.entities.Solution;
import fr.formation.entities.Utilisateur;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={ApplicationContextConfig.class,SpringWebAppInitializer.class})
@Transactional
public class UtilisateurDAOTest {
	
	@Autowired
	private IUtilisateurDAO utilisateurDAO;
	
	@Test
	@Rollback(true)
	public void saveUtilisateur() {
		Utilisateur util = new Utilisateur();
		util.setMdp("test");
		util.setPrenom("test");
		util.setNom("test");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date datejava=null;
		try {
			datejava = simpleDateFormat.parse("2014/11/11");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date = new Date(datejava.getTime());
		util.setDateInsc(date);
		util.setPoste("test");
		util.setRang("test");
		util.setMail("test@test.test");
		List<Utilisateur> utils=utilisateurDAO.getAll();
		int sizeoftable=utils.size();
		utilisateurDAO.save(util);
		utils=utilisateurDAO.getAll();
		
		assertEquals(utils.size(),sizeoftable+1);
	}
	
	@Test
	@Rollback(true)
	public void updateUtilisateur() {
		Utilisateur util = utilisateurDAO.findById(8l);
		util.setNom("test");
		List<Utilisateur> utils=utilisateurDAO.getAll();
		int sizeoftable=utils.size();
		utilisateurDAO.update(util);
		utils=utilisateurDAO.getAll();
		
		assertEquals(utils.size(),sizeoftable);
		assertEquals(utils.get(0).getNom(),"test");
	}
	
	@Test
	@Rollback(true)
	public void deleteUtilisateur() {
		Utilisateur util = new Utilisateur();
		util.setMdp("test");
		util.setPrenom("test");
		util.setNom("test");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date datejava=null;
		try {
			datejava = simpleDateFormat.parse("2014/11/11");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date = new Date(datejava.getTime());
		util.setDateInsc(date);
		util.setPoste("test");
		util.setRang("test");
		util.setMail("test@test.test");
		utilisateurDAO.save(util);
		List<Utilisateur> utils=utilisateurDAO.getAll();
		int sizeoftable=utils.size();
		utilisateurDAO.delete(util);
		utils=utilisateurDAO.getAll();
		assertEquals(utils.size(),sizeoftable-1);
	}
	
	
	@Test
	@Rollback(true)
	public void getUtilisateurByDateInsc() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date datedebut=null;
		java.util.Date datefin=null;
		try {
			datedebut = simpleDateFormat.parse("2014/11/11");
			datefin = simpleDateFormat.parse("2020/01/01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date debut = new Date(datedebut.getTime());
		Date fin = new Date(datefin.getTime());
		
		List<Utilisateur> utils = utilisateurDAO.getByDateInsc(debut, fin);
		assertEquals(utils.size(), 4);
	}
	
	@Test
	@Rollback(true)
	public void getUtilisateurbyMail() {
		String mail="oli@fisch.fr";
		Utilisateur util = utilisateurDAO.getbyMail(mail);
		assertNotNull(util);
		assertEquals(util.getNom(), "FISCHER");
	}
	
	@Test
	@Rollback(true)
	public void getUtilisateurbyRank() {
		String rank="test";
		List<Utilisateur> utils = utilisateurDAO.getbyRank(rank);
		assertNotNull(utils);
		assertEquals(utils.size(), 2);
	}
	
	@Test
	@Rollback(true)
	public void getUtilisateurbyPoste() {
		String poste="test";
		List<Utilisateur> utils = utilisateurDAO.getbyPoste(poste);
		assertNotNull(utils);
		assertEquals(utils.size(), 2);
	}
	
	@Test
	@Rollback(true)
	public void getUtilisateurbyFirstName() {
		String prenom="oli";
		List<Utilisateur> utils = utilisateurDAO.getbyFirstName(prenom);
		assertNotNull(utils);
		assertEquals(utils.get(0).getNom(), "FISCHER");
	}
	
	@Test
	@Rollback(true)
	public void getUtilisateurbyLastName() {
		String nom="fisch";
		List<Utilisateur> utils = utilisateurDAO.getbyLastName(nom);
		assertNotNull(utils);
		assertEquals(utils.get(0).getPrenom(), "Olivier");
	}
	
	@Test
	public void findByIdUtilisateur() {
		Utilisateur util = new Utilisateur();
		util=utilisateurDAO.findById(8l);
		assertEquals(util.getMail(),"oli@fisch.fr");
	}
	
	@Test
	public void getAllSolution() {
		List<Utilisateur> sols = utilisateurDAO.getAll();
		assertEquals(sols.size(), 4);
	}
}
