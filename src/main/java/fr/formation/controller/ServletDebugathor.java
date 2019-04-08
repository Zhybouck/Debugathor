package fr.formation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import fr.formation.beans.Logiciel;
import fr.formation.dao.ILogicielDAO;
import fr.formation.dao.LogicielHome;
import fr.formation.utils.HibernateUtils;

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
		ILogicielDAO dao= new LogicielHome();
		List<Logiciel> ls= dao.getAll();
		for(Logiciel  l: ls) {
			System.out.println(l.toString());
		}
		request.setAttribute("liste", ls);
		request.getRequestDispatcher("debug.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("fin de méthode post");
	}

}
