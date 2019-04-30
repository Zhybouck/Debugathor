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
import fr.formation.entities.Logiciel;
import fr.formation.entities.Solution;
import fr.formation.entities.Utilisateur;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { ApplicationContextConfig.class, SpringWebAppInitializer.class })
@Transactional
public class SolutionServiceTest {

	@Autowired
	private ISolutionService solutionService;
	
	@Autowired
	private ILogicielService logicielService;
	
	@Autowired
	private IUtilisateurService utilisateurService;

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
		Logiciel l=logicielService.findById(18l);
		sol.setLogiciel(l);
		List<Solution> sols = solutionService.getAll();
		int sizeoftable = sols.size();
		solutionService.save(sol);
		sols = solutionService.getAll();

		assertEquals(sols.size(), sizeoftable + 1);
	}

	@Test
	@Rollback(true)
	public void updateSolution() {
		Solution sol = solutionService.findById(11l);
		sol.setTitre("test");
		List<Solution> sols = solutionService.getAll();
		int sizeoftable = sols.size();
		solutionService.update(sol);
		sols = solutionService.getAll();

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
		Logiciel l=logicielService.findById(18l);
		sol.setLogiciel(l);
		solutionService.save(sol);
		List<Solution> sols = solutionService.getAll();
		int sizeoftable = sols.size();
		solutionService.delete(sol);
		sols = solutionService.getAll();
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
			datefin = simpleDateFormat.parse("2020/01/01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date debut = new Date(datedebut.getTime());
		Date fin = new Date(datefin.getTime());
		
		List<Solution> utils = solutionService.getByDateBug(debut, fin);
		assertEquals(utils.size(), 3);
	}
	
	@Test
	@Rollback(true)
	public void getSolutionByTitre() {
		List<Solution> sol = solutionService.getByTitre("titre");
		assertEquals(sol.size(), 1);
	}
	
	@Test
	@Rollback(true)
	public void getSolutionByTechno() {
		List<Solution> sol = solutionService.getByTechno("java");
		assertEquals(sol.size(), 2);
	}
	
	@Test
	@Rollback(true)
	public void getSolutionByIdLogiciel() {
		List<Solution> sol = solutionService.getByidLogiciel(21l);
		assertEquals(sol.size(), 2);
	}
	
	@Test
	@Rollback(true)
	public void getSolutionByLogiciel() {
		Logiciel l=logicielService.findById(21l);
		List<Solution> sol = solutionService.getByLogiciel(l);
		assertEquals(sol.size(), 2);
	}
	
	@Test
	@Rollback(true)
	public void getSolutionByUtilisateur() {
		Utilisateur u = utilisateurService.findById(8l);
		List<Solution> sol = solutionService.getByUtilisateur(u);
		assertEquals(sol.size(), 2);
	}
	@Test
	public void findByIdSolution() {
		Solution sol = new Solution();
		sol=solutionService.findById(13l);
		assertEquals(sol.getDescription(),"c'est un bug");
	}
	
	@Test
	public void getAllSolution() {
		List<Solution> sols = solutionService.getAll();
		assertEquals(sols.size(), 3);
	}
}
