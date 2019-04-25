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
import fr.formation.entities.Logiciel;
import fr.formation.entities.Solution;
import fr.formation.entities.Utilisateur;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { ApplicationContextConfig.class, SpringWebAppInitializer.class })
@Transactional
public class SolutionDAOTest {

	@Autowired
	private ISolutionDAO solutionDAO;
	
	@Autowired
	private ILogicielDAO logicielDAO;
	
	@Autowired
	private IUtilisateurDAO utilisateurDAO;

	@Test
	@Rollback(true)
	public void saveSolution() {
		Solution sol = new Solution();
		sol.setType("NullPointer");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date datejava = null;
		try {
			datejava = simpleDateFormat.parse("2014/11/11");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date = new Date(datejava.getTime());
		sol.setDateBug(date);

		sol.setTitre("comment résoudre un null pointer");
		sol.setDescription("eviter les null");
		sol.setDemarche(
				"avec le débug on peut voir ou ca bug du coup on peut par exemple initialiser sa variable à 1 comme ca plus de null pointer");
		sol.setTechnologie("java");
		Logiciel l=logicielDAO.findById(1l);
		sol.setLogiciel(l);
		List<Solution> sols = solutionDAO.getAll();
		int sizeoftable = sols.size();
		solutionDAO.save(sol);
		sols = solutionDAO.getAll();

		assertEquals(sols.size(), sizeoftable + 1);
	}

	@Test
	@Rollback(true)
	public void updateSolution() {
		Solution sol = solutionDAO.findById(1l);
		sol.setTitre("test");
		List<Solution> sols = solutionDAO.getAll();
		int sizeoftable = sols.size();
		solutionDAO.update(sol);
		sols = solutionDAO.getAll();

		assertEquals(sols.size(), sizeoftable);
		assertEquals(sols.get(0).getTitre(), "test");
	}

	@Test
	@Rollback(true)
	public void deleteSolution() {
		Solution sol = new Solution();
		sol.setType("NullPointer");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date datejava = null;
		try {
			datejava = simpleDateFormat.parse("2014/11/11");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date = new Date(datejava.getTime());
		sol.setDateBug(date);

		sol.setTitre("comment résoudre un null pointer");
		sol.setDescription("eviter les null");
		sol.setDemarche(
				"avec le débug on peut voir ou ca bug du coup on peut par exemple initialiser sa variable à 1 comme ca plus de null pointer");
		sol.setTechnologie("java");
		Logiciel l=logicielDAO.findById(1l);
		sol.setLogiciel(l);
		solutionDAO.save(sol);
		List<Solution> sols = solutionDAO.getAll();
		int sizeoftable = sols.size();
		solutionDAO.delete(sol);
		sols = solutionDAO.getAll();
		assertEquals(sols.size(), sizeoftable-1);
	}
	
	@Test
	@Rollback(true)
	public void getSolutionByDateBug() {
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
		
		List<Solution> utils = solutionDAO.getByDateBug(debut, fin);
		assertEquals(utils.size(), 1);
	}
	
	@Test
	@Rollback(true)
	public void getSolutionByTitre() {
		List<Solution> sol = solutionDAO.getByTitre("ca marche po");
		assertEquals(sol.size(), 1);
	}
	
	@Test
	@Rollback(true)
	public void getSolutionByTechno() {
		List<Solution> sol = solutionDAO.getByTechno("java");
		assertEquals(sol.size(), 2);
	}
	
	@Test
	@Rollback(true)
	public void getSolutionByIdLogiciel() {
		List<Solution> sol = solutionDAO.getByidLogiciel(1l);
		assertEquals(sol.size(), 1);
	}
	
	@Test
	@Rollback(true)
	public void getSolutionByLogiciel() {
		Logiciel l=logicielDAO.findById(1l);
		List<Solution> sol = solutionDAO.getByLogiciel(l);
		assertEquals(sol.size(), 1);
	}
	
	@Test
	@Rollback(true)
	public void getSolutionByUtilisateur() {
		Utilisateur u = utilisateurDAO.findById(1l);
		List<Solution> sol = solutionDAO.getByUtilisateur(u);
		assertEquals(sol.size(), 2);
	}
}
