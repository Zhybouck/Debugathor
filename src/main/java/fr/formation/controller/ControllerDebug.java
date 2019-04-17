package fr.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.entities.Logiciel;
import fr.formation.entities.Proposition;
import fr.formation.entities.Solution;
import fr.formation.entities.Utilisateur;
import fr.formation.services.ILogicielService;
import fr.formation.services.IPropositionService;
import fr.formation.services.ISolutionService;
import fr.formation.services.IUtilisateurService;

@Controller
@Transactional
public class ControllerDebug {
	
	@Autowired
	ILogicielService service;
	
	@Autowired
	ISolutionService servicesol;
	
	@Autowired
	IPropositionService serviceprop;
	
	@Autowired
	IUtilisateurService serviceutil;

	@RequestMapping("/test")
	public String sendAllLogiciel(Model model) {
		
//		List<Logiciel> list=service.getAll();
		Logiciel log=service.findById(2l);
		Utilisateur u= serviceutil.findById(1l);
//		List<Solution> listsol = servicesol.getAll();
//		List<Utilisateur> listutil = serviceutil.getAll();
		List<Proposition> listprop = serviceprop.findAllPropbyUser(u);
//		for(Solution s: listsol)
//			System.out.println(s.toString());
		
//		for(Utilisateur u: listutil)
//			System.out.println(u.toString());
//		
		for(Proposition p: listprop)
			System.out.println(p.toString());
		
//		model.addAttribute("list",listsol);
		return "debug";
	}
}
