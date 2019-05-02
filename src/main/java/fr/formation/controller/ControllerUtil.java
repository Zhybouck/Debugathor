package fr.formation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import fr.formation.cryptlogin.LoginUtils;
import fr.formation.entities.Utilisateur;
import fr.formation.services.IUtilisateurService;

@Controller
@Transactional
@RequestMapping("/user")
public class ControllerUtil {
	private static final Log log = LogFactory.getLog(ControllerUtil.class);

	@Autowired
	IUtilisateurService service;

	@RequestMapping(value = "/init")
	public String initView(Model model, HttpSession session, HttpServletRequest request) {
		log.debug("-------------------------Initialisation des utilisateurs controlleurs---------------------");
		if (null != request.getSession().getAttribute("Utilisateur")) {
			return "redirect:/Solution/init";
		}
		session.setAttribute("Utilisateur", null);
		model.addAttribute("userform", new Utilisateur());

		return "login";
	}

	@RequestMapping(value = "/id", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute("userform") Utilisateur utilisateur, BindingResult result, Model model,
			HttpSession session) {
		log.info("-------------------------Login---------------------");

		if (utilisateur.getMail().equals(null)) {
			log.info("-------------------------L'utilisateur est null---------------------");

			return "redirect:/user/init";
		} else {
			log.info("-------------------------L'utilisateur est pas null---------------------");
			log.info("-------------------------Creation du checkeur---------------------");
			
			if (null != (service.getbyMail(utilisateur.getMail()))) {
				log.info("-------------------------Creation du Checkeur de l'utilisateur---------------------");

				Utilisateur checkeur = service.getbyMail(utilisateur.getMail());

				if (LoginUtils.checkmdp(utilisateur.getMdp(), checkeur.getMdp())) {
					session.setAttribute("Utilisateur", checkeur);
					return "redirect:/Solution/init";
				} else {
					model.addAttribute("Connect", "Mot de passe ou e-mail incorrect");

					return "login";
				}
			} else {
				model.addAttribute("Connect", "Mot de passe ou e-mail incorrect");

				return "login";
			}
		}
	}

	@RequestMapping(value = "/addone")
	public String addUser(Model model) {
		log.debug("-------------------------Initialisation de l'ajout d'un utilisateur---------------------");

		model.addAttribute("creationutilisateur", new Utilisateur());
		return "inscription";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Validated @ModelAttribute("creationutilisateur") Utilisateur crea, BindingResult result,
			Model model, @RequestParam("inputConfPassword") String inputConfPassword) {
		log.debug("-------------------------Debut ajout utilisateur---------------------");

		if(!crea.getMdp().equals(inputConfPassword)) {
			model.addAttribute("confMdp", "Les mots de passes ne correspondent pas");
			return "inscription";
		} else {
			java.util.Date date = new java.util.Date();
			java.sql.Date d = new java.sql.Date(date.getTime());
			Utilisateur exist = service.getbyMail(crea.getMail());
			if (null == exist) {
				if (crea.equals(null)) {
					log.info("l'utilisateur ne peut pas etre créé car il existe déjà");
					model.addAttribute("alreadyinsc", "Cette adresse mail est déjà liée à un compte utilisateur");
					
					return "inscription";
				} else {
					if (result.hasErrors()) {
						log.info("l'utilisateur ne peut pas être créé à cause d'erreurs dans le formulaire");
						return "inscription";
					} else {
						log.debug("-------------------------Ajout Utilisateur---------------------");

						crea.setDateInsc(d);
						crea.setMdp(LoginUtils.hashPassword(crea.getMdp()));
						service.save(crea);

						return "redirect:/user/init";
					}
				}
			} else {
				model.addAttribute("alreadyinsc", "Cette adresse mail est déjà liée à un compte utilisateur");
				log.info("le mail est déjà utilisé");
				return "inscription";
			}
		}
	}

	@RequestMapping(value = "/disconnect")
	public String endSessionHandlingMethod(SessionStatus status, HttpSession session) {
		session.invalidate();
		return "byebye";
	}

}
