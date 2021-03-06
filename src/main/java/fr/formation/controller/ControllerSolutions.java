package fr.formation.controller;

import java.text.DateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
import fr.formation.entities.Solution;
import fr.formation.entities.Utilisateur;
import fr.formation.services.ILogicielService;
import fr.formation.services.IPropositionService;
import fr.formation.services.ISolutionService;

@Controller
@Transactional
@RequestMapping("/Solution")
public class ControllerSolutions {
	private static final Log log = LogFactory.getLog(ControllerSolutions.class);

	@Autowired
	ISolutionService solserv;

	@Autowired
	IPropositionService propserv;

	@Autowired
	ILogicielService logserv;

	// Controller des solutions (ou Bugs)
	// Init est la première methode par laquelle on apsse, genere, la liste des
	// Solutions par appel du GetAll
	@RequestMapping(value = "/init")
	public String init(Model model) {
		log.info("-------------------------Initialisation de la liste globale de toutes les solutions---------------------");

		List<Solution> liste = solserv.getAll();
		model.addAttribute("listesol", liste);
		return "tabBug";
	}

	// lorsque l'on sélectionne une solution cette methode est appelée et renvoie
	// vers la méthode focusBug
	@RequestMapping(value = "/focus")
	public String focusOnOne(@RequestParam("Id") Long Id, Model model) {
		Solution solution = solserv.findById(Id);
		log.info("-------------------------Focus sur une solution---------------------");

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
	@RequestMapping(value = "/update")
	public String updateInit(@RequestParam("Id") Long Id, Model model) {
		log.info("------------------------Initialisation de l'update d'une solution et logiciel associé---------------------");

		model.addAttribute("toUpBug", solserv.findById(Id));
		model.addAttribute("Logiciel", solserv.findById(Id).getLogiciel());
		return "uppBug";
	}

	// Cette requeête est faite pour vérifier les erreurs et renvoyer vers l'update
	// si nécessaire elle renvoie ensuite vers focusBug
	@RequestMapping(value = "/applyUpdate", method = RequestMethod.POST)
	public String updateOne(@Valid @ModelAttribute("toUpBug") Solution toUpBug, Model model, BindingResult result
			,@RequestParam("inputNomLogiciel")String inputNomLogiciel,@RequestParam("inputVersionLogiciel") String versionlogiciel) {
		log.info("------------------------Application de l'update---------------------");

		if (result.hasErrors()) {
			return "uppBug";
		} else {
			//gestion du logiciel
			boolean logexists  = false;
			List<Logiciel> logiciels = logserv.findByName(inputNomLogiciel);
			log.info("------------------------verification de l'existence du logiciel et sa version---------------------");

			for(Logiciel l : logiciels) {
				if(l.getVersion().equals(versionlogiciel)) {
					toUpBug.setLogiciel(l);
					logexists = true;
				}
			}
			Logiciel log = new Logiciel();
			if(logexists==false) {
				log.setNomLogiciel(inputNomLogiciel);
				log.setVersion(versionlogiciel);
				logserv.save(log);
				toUpBug.setLogiciel(log);
			}
			
			ControllerSolutions.log.info("------------------------Etape final de l'update---------------------");

			java.util.Date date = new java.util.Date();
			java.sql.Date datebug = new java.sql.Date(date.getTime());
			toUpBug.setDateBug(datebug);
			List<Proposition> props =  propserv.findAllPropbySolution(toUpBug);
			toUpBug.setPropositions(props);
			//update
			solserv.update(toUpBug);
			
			//ajout des attributs
			model.addAttribute("focusedSol", toUpBug);
			model.addAttribute("nouvProp", new Proposition());
			return "focusBug";
		}
	}

	//Initialise  ajout d'une solution
	@RequestMapping(value = "/initaddsoluce")
	public String initaddsoluce(Solution solution, Model model, BindingResult result) {
		ControllerSolutions.log.info("------------------------inialisation de l'ajout d'une solution---------------------");

		model.addAttribute("Solution", new Solution());
		model.addAttribute("Proposition", new Proposition());
		return "addBug";

	}

	// Cette requête est faite pour ajouter une solution à la base de donnee suite au remplissage du formulaire
	@RequestMapping(value = "/applyadd", method = RequestMethod.POST)
	public String saveOne(@Valid @ModelAttribute("Solution")Solution solution,
			@ModelAttribute("Proposition")Proposition prop, Model model ,BindingResult result,
			HttpSession session, @RequestParam("inputNomLogiciel") String inputNomLogiciel, @RequestParam("inputVersionLogiciel") String versionlogiciel) {
		ControllerSolutions.log.info("------------------------application de l'ajout d'une solution---------------------");

		if(result.hasErrors()) {
			model.addAttribute("completer", "Tous les champs doivent être remplis");
			return "addBug";
		} else {
		
		boolean logexists  = false;
		List<Logiciel> logiciels = logserv.findByName(inputNomLogiciel);
		for(Logiciel l : logiciels) {
			if(l.getVersion().equals(versionlogiciel)) {
				solution.setLogiciel(l);
				logexists = true;
			}
		}
		Logiciel log = new Logiciel();
		if(logexists==false) {
			log.setNomLogiciel(inputNomLogiciel);
			log.setVersion(versionlogiciel);
			logserv.save(log);
			solution.setLogiciel(log);
		}
		java.util.Date date = new java.util.Date();
		java.sql.Date datebug = new java.sql.Date(date.getTime());
		solution.setDateBug(datebug);
		
		
		solserv.save(solution);
		Utilisateur util = (Utilisateur)session.getAttribute("Utilisateur");
		prop.setSolution(solution);
		prop.setUtilisateur(util);
		java.sql.Date d = new java.sql.Date(date.getTime());
		prop.setDateProp(d);
		prop.setCommentaire("Creation de la solution le " + DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(date)+ " par " + util.getPrenom()+ " "+ util.getNom());
		propserv.save(prop);
		model.addAttribute("focusedSol", solserv.findById((solution).getIdSolution()));
		model.addAttribute("nouvProp",new Proposition());
		return "focusBug";
	}
	}



//Affiche l'ensemble des bugs associés a un utilisateur
	@RequestMapping(value = "/mybugs")
	public String printmybugs(HttpSession session, Model model) {
		ControllerSolutions.log.info("------------------------Recuperation de la liste des bugs associés a la session---------------------");

		Utilisateur util = (Utilisateur) session.getAttribute("Utilisateur");
		List<Solution> listesol = solserv.getByUtilisateur(util);
		model.addAttribute("listesol", listesol);
		return "myBugs";
	}
	
	//Supprime un bug lié à la session en cours et donc à l'utilisateur connecté
	@RequestMapping(value = "/delete")
	public String delete(HttpSession session, Utilisateur Utils, @RequestParam("Id") Long id) {
		ControllerSolutions.log.info("------------------------Suppression d'un bug---------------------");

		Solution solution = solserv.findById(id);
		List<Proposition> props = propserv.findAllPropbySolution(solution);
		for (Proposition p: props) {
			propserv.delete(p);
		}
		solserv.delete(solution);
		return "redirect:/Solution/mybugs";
	}
	
	
	@RequestMapping(value = "/addprop", method = RequestMethod.POST)
	public String addProposition(HttpSession session, Model model, @ModelAttribute("nouvProp")Proposition proposition,@RequestParam("idSol")Long id) {
		ControllerSolutions.log.info("------------------------Ajout d'une proposition---------------------");

		Utilisateur util = (Utilisateur) session.getAttribute("Utilisateur");
		java.util.Date date = new java.util.Date();
		java.sql.Date dateprop = new java.sql.Date(date.getTime());
		proposition.setDateProp(dateprop);
		proposition.setUtilisateur(util);
		Solution solution = solserv.findById(id);
		proposition.setSolution(solution);
		propserv.save(proposition);
		List<Proposition> props = propserv.findAllPropbySolution(solution);
		solution.setPropositions(props);
		solserv.update(solution);
		solution = solserv.findById(id);
		model.addAttribute("focusedSol", solution);
		model.addAttribute("nouvProp", new Proposition());

		return "focusBug";
	}
	
	// Afin de back d'une page direction l'accueil des Solutions soit a la liste du
	// tableau
	@RequestMapping(value = "/back")
	public String back() {
		ControllerSolutions.log.info("------------------------Retour vers la méthode affichant toutes les solutions---------------------");

		return "redirect:/Solution/init";
	}

	@RequestMapping(value = "/disconnect")
	public String endSessionHandlingMethod(HttpSession session) {
		ControllerSolutions.log.info("------------------------Methode de déconnection---------------------");

		session.invalidate();
		return "byebye";
	}
}
