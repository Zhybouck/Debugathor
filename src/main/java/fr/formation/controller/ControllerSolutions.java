package fr.formation.controller;

import java.text.DateFormat;
import java.util.List;
import java.util.Set;

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

import fr.formation.entities.Logiciel;
import fr.formation.entities.Proposition;
import fr.formation.entities.PropositionId;
import fr.formation.entities.Solution;
import fr.formation.entities.Utilisateur;
import fr.formation.services.ILogicielService;
import fr.formation.services.IPropositionService;
import fr.formation.services.ISolutionService;

@Controller
@Transactional
@RequestMapping("/Solution")
public class ControllerSolutions {

	@Autowired
	ISolutionService solserv;

	@Autowired
	IPropositionService propserv;

	@Autowired
	ILogicielService logserv;

	// Controller des solutions (ou Bugs)
	// Init est la première methode par laquelle on apsse, genere, la liste des
	// Solutions par appel du GetAll
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public String init(Model model) {
		List<Solution> liste = solserv.getAll();
		model.addAttribute("listesol", liste);
		return "tabBug";
	}

	// lorsque l'on sélectionne une solution cette methode est appelée et renvoie
	// vers la méthode focusBug
	@RequestMapping(value = "/focus", method = RequestMethod.POST)
	public String focusOnOne(@RequestParam("Id") Long Id, Model model) {
		Solution solution = solserv.findById(Id);
		model.addAttribute("focusedSol", solution);
		model.addAttribute("nouvProp", new Proposition());
		return "focusBug";
	}

	@RequestMapping(value = "/focusplusprop", method = RequestMethod.POST)
	public String focusPlusProp(@RequestParam("Id") Long Id, @ModelAttribute("focusedSol") Solution solution,
			Model model, HttpSession session, @ModelAttribute("nouvProp") Proposition proposition) {

		model.addAttribute("focusedSol", solution);
		model.addAttribute("nouvProp", new Proposition());
		return "redirect:/Solution/focus";
	}

	// Depusi une page avec plusieurs ou un seul bug on peut appeler cette méthode
	// afin d'update un Bug/solution
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateInit(@RequestParam("Id") Long Id, Model model) {
		model.addAttribute("toUpBug", solserv.findById(Id));
		return "uppBug";
	}

	// Cette requeête est faite pour vérifier les erreurs et renvoyer vers l'update
	// si nécessaire elle renvoie ensuite vers focusBug
	@RequestMapping(value = "/applyUpdate", method = RequestMethod.POST)
	public String updateOne(@Valid @ModelAttribute("toUpBug") Solution toUpBug, Model model, BindingResult result) {
		if (result.hasErrors()) {
			return "uppBug";
		} else {
			solserv.update(toUpBug);
			model.addAttribute("Id", toUpBug.getIdSolution());
			return "focusBug";
		}
	}

	@RequestMapping(value = "/initaddsoluce", method = RequestMethod.POST)
	public String initaddsoluce(Solution solution, Model model, BindingResult result) {
		model.addAttribute("Solution", new Solution());
		model.addAttribute("Proposition", new Proposition());
		return "addBug";

	}

	// Cette requête est faite pour ajouter une solution à la base de donnee
	@RequestMapping(value = "/applyadd", method = RequestMethod.POST)
	public String saveOne(@ModelAttribute("Solution")Solution solution,
			@ModelAttribute("Proposition")Proposition prop, Model model ,BindingResult result,
			HttpSession session, @RequestParam("inputNomLogiciel") String nomlogiciel, @RequestParam("inputVersionLogiciel") String versionlogiciel) {
		
		if(result.hasErrors()) {
			return "addBug";
		}
		
		boolean logexists  = false;
		List<Logiciel> logiciels = logserv.findByName(nomlogiciel);
		for(Logiciel l : logiciels) {
			if(l.getVersion().equals(versionlogiciel)) {
				solution.setLogiciel(l);
				logexists = true;
			}
		}
		Logiciel log = new Logiciel();
		if(logexists==false) {
			log.setNomLogiciel(nomlogiciel);
			log.setVersion(versionlogiciel);
			logserv.save(log);
//			List<Logiciel> logs = logserv.getAll();
//			log=logs.get(logs.size()-1);
			solution.setLogiciel(log);
		}
		java.util.Date date = new java.util.Date();
		java.sql.Date datebug = new java.sql.Date(date.getTime());
		solution.setDateBug(datebug);
		
		
		solserv.save(solution);
		Utilisateur util = (Utilisateur)session.getAttribute("Utilisateur");
		prop.setId(new PropositionId(util.getIdUtilisateur(), solution.getIdSolution()));
		prop.setSolution(solution);
		prop.setUtilisateur(util);
		java.sql.Date d = new java.sql.Date(date.getTime());
		prop.setDateProp(d);
		prop.setCommentaire("Creation de la solution le " + DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(date)+ " par " + util.getPrenom()+ " "+ util.getNom());
		propserv.save(prop);
		model.addAttribute("Solution", solserv.findById((solution).getIdSolution()));
		return "focusBug";
	}

	// Afin de back d'une page direction l'accueil des Solutions soit a la liste du
	// tableau
	@RequestMapping(value = "/back", method = RequestMethod.POST)
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
	
	
	@RequestMapping(value = "/addprop", method = RequestMethod.POST)
	public String addProposition(HttpSession session, Model model, @ModelAttribute("nouvProp")Proposition proposition,@RequestParam("idSol")Long id) {
		Utilisateur util = (Utilisateur) session.getAttribute("Utilisateur");
		PropositionId propId = new PropositionId(util.getIdUtilisateur(), id) ;
		proposition.setId(propId);
		java.util.Date date = new java.util.Date();
		java.sql.Date dateprop = new java.sql.Date(date.getTime());
		proposition.setDateProp(dateprop);
		proposition.setUtilisateur(util);
		Solution solution = solserv.findById(id);
		proposition.setSolution(solution);
		propserv.save(proposition);
		Set<Proposition> props = solution.getPropositions();
		props.add(proposition);
		solution.setPropositions(props);
		solserv.update(solution);
		solution = solserv.findById(id);
		model.addAttribute("focusedSol", solution);
		model.addAttribute("nouvProp", new Proposition());

		return "focusBug";
	}
}
