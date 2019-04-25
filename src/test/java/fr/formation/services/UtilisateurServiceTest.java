package fr.formation.services;

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
import fr.formation.entities.Utilisateur;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={ApplicationContextConfig.class,SpringWebAppInitializer.class})
@Transactional
public class UtilisateurServiceTest {
	
	@Autowired
	private IUtilisateurService utilisateurService;
	
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
		List<Utilisateur> utils=utilisateurService.getAll();
		int sizeoftable=utils.size();
		utilisateurService.save(util);
		utils=utilisateurService.getAll();
		
		assertEquals(utils.size(),sizeoftable+1);
	}
	
	@Test
	@Rollback(true)
	public void updateUtilisateur() {
		Utilisateur util = utilisateurService.findById(1l);
		util.setNom("test");
		List<Utilisateur> utils=utilisateurService.getAll();
		int sizeoftable=utils.size();
		utilisateurService.update(util);
		utils=utilisateurService.getAll();
		
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
		utilisateurService.save(util);
		List<Utilisateur> utils=utilisateurService.getAll();
		int sizeoftable=utils.size();
		utilisateurService.delete(util);
		utils=utilisateurService.getAll();
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
			datefin = simpleDateFormat.parse("2018/01/01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date debut = new Date(datedebut.getTime());
		Date fin = new Date(datefin.getTime());
		
		List<Utilisateur> utils = utilisateurService.getByDateInsc(debut, fin);
		assertEquals(utils.size(), 1);
	}
	
	@Test
	@Rollback(true)
	public void getUtilisateurbyMail() {
		String mail="test@mail";
		Utilisateur util = utilisateurService.getbyMail(mail);
		assertNotNull(util);
		assertEquals(util.getNom(), "fisch");
	}
	
	@Test
	@Rollback(true)
	public void getUtilisateurbyRank() {
		String rank="test";
		List<Utilisateur> utils = utilisateurService.getbyRank(rank);
		assertNotNull(utils);
		assertEquals(utils.size(), 2);
	}
	
	@Test
	@Rollback(true)
	public void getUtilisateurbyPoste() {
		String poste="test";
		List<Utilisateur> utils = utilisateurService.getbyPoste(poste);
		assertNotNull(utils);
		assertEquals(utils.size(), 2);
	}
	
	@Test
	@Rollback(true)
	public void getUtilisateurbyFirstName() {
		String prenom="oli";
		List<Utilisateur> utils = utilisateurService.getbyFirstName(prenom);
		assertNotNull(utils);
		assertEquals(utils.get(0).getNom(), "fisch");
	}
	
	@Test
	@Rollback(true)
	public void getUtilisateurbyLastName() {
		String nom="fisch";
		List<Utilisateur> utils = utilisateurService.getbyLastName(nom);
		assertNotNull(utils);
		assertEquals(utils.get(0).getPrenom(), "oli");
	}
}
