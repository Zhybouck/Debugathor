package fr.formation.utils;

import org.springframework.context.annotation.Bean;

import fr.formation.dao.LogicielDAO;
import fr.formation.dao.PropositionDAO;
import fr.formation.dao.SolutionDAO;
import fr.formation.dao.UtilisateurDAO;
import fr.formation.services.LogicielService;
import fr.formation.services.PropositionService;
import fr.formation.services.SolutionService;
import fr.formation.services.UtilisateurService;


public class Config {
	
	
	/*
	 * beans logiciel
	 */
	@Bean
	public LogicielService logicielService(){
		return new LogicielService();
	}
	@Bean
	public LogicielDAO logicielDAO(){
		return new LogicielDAO();
	}
	
	/*
	 * beans proposition
	 */
	@Bean
	public PropositionService propositionService(){
		return new PropositionService();
	}
	@Bean
	public PropositionDAO propositionDAO(){
		return new PropositionDAO();
	}
	
	/*
	 * beans solution
	 */
	@Bean
	public SolutionService solutionService(){
		return new SolutionService();
	}
	@Bean
	public SolutionDAO solutionDAO(){
		return new SolutionDAO();
	}
	
	
	
	/*
	 * beans utilisateurs
	 */
	@Bean
	public UtilisateurService utilisateurService(){
		return new UtilisateurService();
	}
	@Bean
	public UtilisateurDAO utilisateurDAO(){
		return new UtilisateurDAO();
	}
}
