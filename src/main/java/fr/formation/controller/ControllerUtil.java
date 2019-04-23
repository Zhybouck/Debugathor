package fr.formation.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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

import fr.formation.entities.Utilisateur;
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
	public String doLogin(@ModelAttribute("userform") Utilisateur utilisateur, BindingResult result, Model model) {
		String mail = utilisateur.getMail();
		Utilisateur checkeur = service.getbyMail(mail);
		if ((utilisateur.getMail().equals(checkeur.getMail()) && (utilisateur.getMdp().equals(checkeur.getMdp())))) {

			model.addAttribute("Utilisateur", checkeur);
			return "redirect:/Solution/init";
		} else {
			return "Accueil";
		}
	}

	@RequestMapping(value = "/addone", method = RequestMethod.POST)
	public String addUser(Model model) {
		model.addAttribute("creationutilisateur", new Utilisateur());
		return "CreaCompte";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("creationutilisateur") Utilisateur crea, BindingResult result,
			Model model) {
		System.out.println(crea);
		java.util.Date date = new java.util.Date();

		java.sql.Date d = new java.sql.Date(date.getTime());
		crea.setDateInsc(d);
		System.out.println(crea);
		if (crea.equals(null)) {
			return "CreaCompte";
		} else {
			System.out.println("avant le check des erreurs" + crea);
			if (result.hasErrors()) {
				System.out.println("Si ya des erreurs" + crea);

				return "CreaCompte";
			} else {
				service.save(crea);
				return "redirect:/user/init";
			}
		}
	}
	
	
	

	@RequestMapping("/disconnect")
	public String endSessionHandlingMethod(SessionStatus status) {
		status.setComplete();
		return "Accueil";
	}

}
