package fr.formation.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.entities.Proposition;
import fr.formation.entities.PropositionId;
import fr.formation.entities.Solution;
import fr.formation.entities.Utilisateur;
import fr.formation.services.IPropositionService;
import fr.formation.services.ISolutionService;

@Controller
@Transactional
@RequestMapping("/Solution")
public class ControllerSolutions {
	
	@Autowired
	ISolutionService solserv;
	
	@Autowired
	IPropositionService	propserv;
	
	//Controller des solutions (ou Bugs)
	//Init est la première methode par laquelle on apsse, genere, la liste des Solutions par appel du GetAll
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public String init(Model model) {
		List<Solution> liste = solserv.getAll();
		model.addAttribute("listesol", liste);
		return "tabBug";
	}
	
	//lorsque l'on sélectionne une solution cette methode est appelée et renvoie vers la méthode focusBug
	@RequestMapping(value = "/focus", method = RequestMethod.POST)
	public String focusOnOne(@RequestParam("Id")Long Id, Model model) {
		model.addAttribute("focusedSol", solserv.findById(Id));
		return "focusBug";
	}
	
	//Depusi une page avec plusieurs ou un seul bug on peut appeler cette méthode afin d'update un Bug/solution
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateInit(@ModelAttribute("Id")Long Id, Model model) {
		model.addAttribute("toUpBug", solserv.findById(Id));
		return "uppBug";
	}
	
	//Cette requeête est faite pour vérifier les erreurs et renvoyer vers l'update si nécessaire elle renvoie ensuite vers focusBug
	@RequestMapping(value = "/applyUpdate", method = RequestMethod.POST)
	public String updateOne(@Valid @ModelAttribute("toUpBug")Solution toUpBug, Model model ,BindingResult result) {
		if(result.hasErrors()) {
			return "uppBug";
		}
		else {
			solserv.update(toUpBug);
			model.addAttribute("Id", toUpBug.getIdSolution());
			return "focusBug";
		}
	}
	
	@RequestMapping(value = "/initaddsoluce", method = RequestMethod.POST)
	public String initaddsoluce(Solution solution, Model model ,BindingResult result) {
		model.addAttribute("Solution", new Solution());
		model.addAttribute("Proposition", new Proposition());
		return "addBug";
		
	}
	
	//Cette requête est faite pour ajouter une solution à la base de donnee
	@RequestMapping(value = "/applyadd", method = RequestMethod.POST)
	public String saveeOne(@ModelAttribute("Solution")Solution solution, @ModelAttribute("Proposition")Proposition prop, Model model ,BindingResult result, HttpSession session) {
		
		if(result.hasErrors()) {
			return "addBug";
		}
		
		solserv.save(solution);
		Utilisateur util = (Utilisateur)session.getAttribute("Utilisateur");
		prop.setId(new PropositionId(util.getIdUtilisateur(), solution.getIdSolution()));
		prop.setSolution(solution);
		prop.setUtilisateur(util);
		java.util.Date date = new java.util.Date();
		java.sql.Date d = new java.sql.Date(date.getTime());
		prop.setDateProp(d);
		
		propserv.save(prop);
		model.addAttribute("Solution", solserv.findById((solution).getIdSolution()));
		return "focusBug";
	}
	
	//Afin de back d'une page direction l'accueil des Solutions soit a la liste du tableau
	@RequestMapping(value="/back", method = RequestMethod.POST)
	public String back() {
		return "redirect:/Solution/init";

	}
	
	@RequestMapping(value = "/disconnect", method = RequestMethod.POST)
	public String endSessionHandlingMethod(HttpSession session) {
		session.invalidate();
		return "byebye";
	} 
	
//Affiche l'ensemble des bugs associés a un utilisateur
	@RequestMapping(value = "/mybugs", method = RequestMethod.POST)
	public String printmybugs(HttpSession session, Model model) {
		Utilisateur util = (Utilisateur) session.getAttribute("Utilisateur");
		List<Solution> listesol = solserv.getByUtilisateur(util);
		
		model.addAttribute("listesol", listesol);

		return "myBugs";
	} 

}
