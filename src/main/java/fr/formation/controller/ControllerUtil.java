package fr.formation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import fr.formation.entities.Solution;
import fr.formation.entities.Utilisateur;
import fr.formation.services.ISolutionService;
import fr.formation.services.IUtilisateurService;

@Controller
@Transactional
@SessionAttributes("Utilisateur")
@RequestMapping("/user")
public class ControllerUtil {

	@Autowired
	IUtilisateurService service;

	
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public String initView(Model model) {
		model.addAttribute("userform", new Utilisateur());
		return "Accueil";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute("userform") Utilisateur utilisateur, BindingResult result,
			Model model) {
		System.out.println("Utilisateur ==>"+ utilisateur);
		String mail = utilisateur.getMail();
		System.out.println("Mail ==>" + mail);
		Utilisateur checkeur = service.getbyMail(mail);
		System.out.println("checkeur ====> " + checkeur);
		if ((utilisateur.getMail().equals(checkeur.getMail()) && (utilisateur.getMdp().equals(checkeur.getMdp())))) {
			
			model.addAttribute("Utilisateur", checkeur);
			return "redirect:/Solution/init";  
			} else {
			return "Accueil";
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("adduser") Utilisateur utilisateur, BindingResult result, Model model) {

		if (utilisateur.equals(null)) {
			return "CreaCompte";
		} else {
			if (result.hasErrors()) {
				return "CreaCompte";
			} else {
				service.save(utilisateur);
				return "tabBug";
			}
		}
	}


	
	@RequestMapping("/disconnect")
	public String endSessionHandlingMethod(SessionStatus status) {
		status.setComplete();
		return "Accueil";
	}

}
