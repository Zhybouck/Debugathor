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

import fr.formation.entities.Solution;
import fr.formation.services.ISolutionService;

@Controller
@Transactional
@RequestMapping("/Solution")
public class ControllerSolutions {
	
	@Autowired
	ISolutionService solserv;
	
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
		return "addBug";
		
	}
	
	
	
	
	
	//Cette requête est faite pour ajouter une solution à la base de donnee
	@RequestMapping(value = "/applyadd", method = RequestMethod.POST)
	public String saveeOne(@ModelAttribute("Solution")Solution solution, Model model ,BindingResult result) {
		
		if(result.hasErrors()) {
			return "addBug";
		}
		solserv.save(solution);
		model.addAttribute("focusedSol", solserv.findById((solution).getIdSolution()));
		return "focusBug";
	}
	
	//Afin de back d'une page direction l'accueil des Solutions soit a la liste du tableau
	public String back() {
		return "redirect:/Solution/init";

	}
	
	@RequestMapping(value = "/disconnect", method = RequestMethod.POST)
	public String endSessionHandlingMethod(HttpSession session) {
		session.invalidate();
		return "byebye";
	} 

}
