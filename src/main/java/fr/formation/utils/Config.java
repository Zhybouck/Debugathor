package fr.formation.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.formation.dao.LogicielDAO;
import fr.formation.dao.PropositionDAO;
import fr.formation.dao.SolutionDAO;
import fr.formation.dao.UtilisateurDAO;
import fr.formation.services.LogicielService;
import fr.formation.services.PropositionService;
import fr.formation.services.SolutionService;
import fr.formation.services.UtilisateurService;

@Configuration
public class Config {
	
	
	/*
	 * beans logiciel
	 */
	@Bean
	public LogicielService ServiceLogiciel(){
		return new LogicielService();
	}
	@Bean
	public LogicielDAO logDao(){
		return new LogicielDAO();
	}
	
	/*
	 * beans proposition
	 */
	@Bean
	public PropositionService ServiceProposition(){
		return new PropositionService();
	}
	@Bean
	public PropositionDAO propDao(){
		return new PropositionDAO();
	}
	
	/*
	 * beans solution
	 */
	@Bean
	public SolutionService ServiceSolution(){
		return new SolutionService();
	}
	@Bean
	public SolutionDAO solDao(){
		return new SolutionDAO();
	}
	
	
	
	/*
	 * beans utilisateurs
	 */
	@Bean
	public UtilisateurService ServiceUtilisateur(){
		return new UtilisateurService();
	}
	
	@Bean
	public UtilisateurDAO utilDao(){
		return new UtilisateurDAO();
	}
}
