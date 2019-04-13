package fr.formation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.dao.ILogicielDAO;
import fr.formation.dao.IPropositionDAO;
import fr.formation.dao.ISolutionDAO;
import fr.formation.dao.IUtilisateurDAO;
import fr.formation.dao.LogicielDAO;
import fr.formation.dao.PropositionDAO;
import fr.formation.dao.SolutionDAO;
import fr.formation.dao.UtilisateurDAO;
import fr.formation.entities.Logiciel;
import fr.formation.entities.Proposition;
import fr.formation.entities.Solution;
import fr.formation.entities.Utilisateur;

/**
 * Servlet implementation class ServletDebugathor
 */
@WebServlet("/debug")
public class ServletDebugathor extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletDebugathor() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ILogicielDAO daol= new LogicielDAO();
		ISolutionDAO daos= new SolutionDAO();
		IUtilisateurDAO daou = new UtilisateurDAO();
		IPropositionDAO daop= new PropositionDAO();
		List<Logiciel> ll= daol.findByName("eclipse");
//		List<Solution> ls= daos.getAll();
//		List<Utilisateur> lu= daou.getAll();
//		List<Proposition> lp= daop.getAll();
		request.setAttribute("ll", ll);
//		request.setAttribute("ls", ls);
//		request.setAttribute("lu", lu);
//		request.setAttribute("lp", lp);
		request.getRequestDispatcher("debug.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("fin de m�thode post");
	}

}
