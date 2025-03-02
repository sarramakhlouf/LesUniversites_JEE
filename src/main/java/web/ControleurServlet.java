package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.IUniversiteDao;
import dao.UniversiteDaoImpl;
import metier.Universite;

@WebServlet(name = "cs", urlPatterns = { "/controleur", "*.do" })
public class ControleurServlet extends HttpServlet {

	IUniversiteDao metier;

	@Override
	public void init() throws ServletException {
		metier = new UniversiteDaoImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/index.do")) {

			request.getRequestDispatcher("universites.jsp").forward(request, response);
		} else if (path.equals("/chercher.do")) {
			String motCle = request.getParameter("motCle");
			UniversiteModele model = new UniversiteModele();
			model.setMotCle(motCle);
			List<Universite> unis = metier.universitesParMC(motCle);
			model.setUniversites(unis);
			request.setAttribute("model", model);

			request.getRequestDispatcher("universites.jsp").forward(request, response);
		} else if (path.equals("/saisie.do")) {

			request.getRequestDispatcher("saisieUniversite.jsp").forward(request, response);
		} else if (path.equals("/save.do") && request.getMethod().equals("POST")) {
			String nomUni = request.getParameter("nomUni");
			String adresseUni = request.getParameter("adresseUni");
			String email = request.getParameter("email");
			double nbEtudiants = Double.parseDouble(request.getParameter("nbEtudiants"));
			Universite u = metier.save(new Universite(nomUni, adresseUni,email, nbEtudiants ));
			request.setAttribute("universite", u);
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);
		} else if (path.equals("/supprimer.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			metier.deleteUniversite(id);
			response.sendRedirect("chercher.do?motCle=");
		} else if (path.equals("/editer.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Universite u = metier.getUniversite(id);
			request.setAttribute("universite", u);
			request.getRequestDispatcher("editerUniversite.jsp").forward(request, response);
		} else if (path.equals("/update.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			String nomUni = request.getParameter("nomUni");
			String adresseUni = request.getParameter("adresseUni");
			String email = request.getParameter("email");
			double nbEtudiants = Double.parseDouble(request.getParameter("nbEtudiants"));
			Universite u = new Universite(nomUni, adresseUni, email, nbEtudiants);
			u.setIdUni(id);
			u.setNomUni(nomUni);
			u.setAdresseUni(adresseUni);
			u.setEmail(email);
			u.setNbEtudiants(nbEtudiants);
			metier.updateUniversite(u);
			request.setAttribute("universite", u);
			//request.getRequestDispatcher("confirmation.jsp").forward(request, response);
			response.sendRedirect("chercher.do?motCle="); 
		} else {
			response.sendError(Response.SC_NOT_FOUND);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}