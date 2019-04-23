package fr.formation.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	public String sendAllLogiciel(Model model) throws ParseException{
		
//		List<Logiciel> list=service.getAll();
		Logiciel log=service.findById(2l);
		Utilisateur u= serviceutil.findById(2l);
		
//		List<Solution> listsol = servicesol.getAll();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date debut;
		debut = simpleDateFormat.parse("2014/11/11");
		Date fin;
		fin = simpleDateFormat.parse("2021/12/25");
		List<Solution> listsol=servicesol.getByUtilisateur(u);
		List<Utilisateur> listutil = serviceutil.getByDateInsc(debut, fin);
		List<Proposition> listprop = serviceprop.findAllPropbyUser(u);
		for(Solution s: listsol)
			System.out.println(s.toString());
		
//		for(Utilisateur u: listutil)
//			System.out.println(u.toString());
//		
//		for(Proposition p: listprop)
//			System.out.println(p.toString());
		
//		model.addAttribute("list",listsol);
		return "debug";
	}
}
