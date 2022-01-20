package mon.projet.controllers;

import java.io.IOException; 
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import mon.projet.dao.UtilisateurLocal;
import mon.projet.entities.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private UtilisateurLocal metier;
     
    public UserServlet() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	if ("add".equals(request.getParameter("action"))) {
            System.out.println("voila la date" + request.getParameter("date"));
            metier.create(new User(request.getParameter("email"), request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("tele"), new Date(request.getParameter("date").replace("-", "/"))));
            response.setContentType("application/json");
            List<User> users = new ArrayList<>();
            for (User p : metier.findAll()) {
                users.add(new User(p.getId(), p.getEmail(), p.getNom(), p.getPrenom(), p.getTelephone(), p.getDateNaissance()));
                
            }
            Gson json = new Gson();
            response.getWriter().write(json.toJson(users));
        } else if ("update".equals(request.getParameter("action"))) {
            System.out.println("voila la date" + request.getParameter("date"));
            metier.update(new User(Integer.parseInt(request.getParameter("id")), request.getParameter("email"), request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("tele"), new Date(request.getParameter("date").replace("-", "/"))));
            response.setContentType("application/json");
            List<User> users = new ArrayList<>();
            for (User p : metier.findAll()) {
            	users.add(new User(p.getId(), p.getEmail(), p.getNom(), p.getPrenom(), p.getTelephone(), p.getDateNaissance()));
                
            }
            
            Gson json = new Gson();
            response.getWriter().write(json.toJson(users));
        } else if ("delete".equals(request.getParameter("action"))) {
        	System.out.println(Integer.parseInt(request.getParameter("id")));
        	try {
                metier.delteById(metier.findById(Integer.parseInt(request.getParameter("id"))));
        	}catch (Exception e) {
				e.printStackTrace();
			}
            response.setContentType("application/json");
            List<User> users = metier.findAll();
            Gson json = new Gson();
            response.getWriter().write(json.toJson(users));
        } else if ("edit".equals(request.getParameter("action"))) {
            response.setContentType("application/json");
            User user = metier.findById(Integer.parseInt(request.getParameter("id")));
            Gson json = new GsonBuilder().setDateFormat(DateFormat.SHORT, DateFormat.SHORT).create();
            response.getWriter().write(json.toJson(user));
        } else if ("search".equals(request.getParameter("action"))) {
            
            response.setContentType("application/json");
            List<User> professeurs = new ArrayList<>();
//            for (User p : metier.findProfessorBySpc(serviceSpc.findById(Integer.parseInt(request.getParameter("id"))))) {
//                professeurs.add(new Professeur(p.getId(), p.getNom(), p.getPrenom(), p.getTele(), p.getEmail(), p.getDate(), p.getSexe(), p.findSpecialite()));
//                
//            }
            
            Gson json = new Gson();
            response.getWriter().write(json.toJson(professeurs));
        } else if ("searchdate".equals(request.getParameter("action"))) {
            
//          
        } else if ("listspc".equals(request.getParameter("action"))) {
//          
        } else {
        	response.setContentType("application/json");
            List<User> users = new ArrayList<>();
            for (User p : metier.findAll()) {
                users.add(new User(p.getId(), p.getEmail(), p.getNom(), p.getPrenom(), p.getTelephone(), p.getDateNaissance()));
                
            }
            Gson json = new Gson();
            response.getWriter().write(json.toJson(users));
            
        }
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
