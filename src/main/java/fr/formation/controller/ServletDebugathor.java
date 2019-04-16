package fr.formation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import fr.formation.dao.LogicielDAO;
import fr.formation.entities.Logiciel;
import fr.formation.services.LogicielService;

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
		LogicielDAO daol= new LogicielDAO();
		ServletContext servcont= getServletContext();
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servcont);
        LogicielService serv= context.getBean("serviceLogiciel",LogicielService.class);
        //normalWebAppContext.setConfigLocation("/WEB-INF/normal-webapp-servlet.xml");
//		LogicielDAO serv = (LogicielDAO) context.getBean("logicielDAO");
//		System.out.println(" =================== findbyid =================");
//		System.out.println(empserv.findById(7369l));
//		
		System.out.println(" =================== getAll =================");
		List<Logiciel> list=serv.getAll();
		for(Logiciel e : list) {
			System.out.println(e);
		}
//		ISolutionDAO daos= new SolutionDAO();
//		IUtilisateurDAO daou = new UtilisateurDAO();
//		IPropositionDAO daop= new PropositionDAO();
		List<Logiciel> ll= daol.getAll();		
//		Logiciel l = daol.findById(1);
//		List<Solution> ls= daos.getAll();
//		List<Utilisateur> lu= daou.getAll();
//		Utilisateur user = daou.findById(1);
//		List<Proposition> lp= daop.getAll();
//		request.setAttribute("ll", ll);
//		System.out.println(ll.toString());
//		request.setAttribute("ls", ls);
//		request.setAttribute("lu", lu);
//		request.setAttribute("lp", lp);
//		request.setAttribute("user", user);
		System.out.println(ll.toString());
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
