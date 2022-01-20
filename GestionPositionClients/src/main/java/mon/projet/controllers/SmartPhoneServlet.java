package mon.projet.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import mon.projet.dao.SmartphoneLocal;
import mon.projet.dao.UtilisateurLocal;
import mon.projet.entities.SmartPhone;
import mon.projet.entities.User;

/**
 * Servlet implementation class SmartphoneController
 */
@WebServlet("/SmartPhoneServlet")
public class SmartPhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
    private SmartphoneLocal metier;
	@EJB
	private UtilisateurLocal metier1;
    
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	if ("add".equals(request.getParameter("action"))) {
    		System.out.println(request.getParameter("user"));
    		metier.create(new SmartPhone(request.getParameter("imei"), metier1.findById(Integer.parseInt(request.getParameter("user")))));
            response.setContentType("application/json");
            List<SmartPhone> smartPhones = new ArrayList<>();
            for (SmartPhone p : metier.findAll()) {
            	smartPhones.add(new SmartPhone(p.getId(),p.getImei(), p.getUtilisateur()));
                
            }
            Gson json = new Gson();
            response.getWriter().write(json.toJson(smartPhones));
        } else if ("update".equals(request.getParameter("action"))) {
            System.out.println("voila la date " + request.getParameter("date"));
            metier.update(new SmartPhone(Integer.parseInt(request.getParameter("id")), request.getParameter("imei"),metier1.findById(Integer.parseInt( request.getParameter("user")))));
            response.setContentType("application/json");
            List<SmartPhone> users = new ArrayList<>();
            for (SmartPhone p : metier.findAll()) {
            	users.add(new SmartPhone(p.getId(), p.getImei(),p.getUtilisateur()));
                
            }
            
            Gson json = new Gson();
            response.getWriter().write(json.toJson(users));
        } else if ("delete".equals(request.getParameter("action"))) {
        	//System.out.println("**************id***********"+metier.findById(Integer.parseInt(request.getParameter("id"))).getImei());
            metier.delteById(metier.findById(Integer.parseInt(request.getParameter("id"))));
            response.setContentType("application/json");
            List<SmartPhone> smartPhones = metier.findAll();
            Gson json = new Gson();
            response.getWriter().write(json.toJson(smartPhones));
        } else if ("edit".equals(request.getParameter("action"))) {
            response.setContentType("application/json");
            SmartPhone user = metier.findById(Integer.parseInt(request.getParameter("id")));
            Gson json = new GsonBuilder().setDateFormat(DateFormat.SHORT, DateFormat.SHORT).create();
            response.getWriter().write(json.toJson(user));
        } else if ("search".equals(request.getParameter("action"))) {
            
            response.setContentType("application/json");
            List<User> professeurs = new ArrayList<>();
            
            Gson json = new Gson();
            response.getWriter().write(json.toJson(professeurs));
        } else if ("searchdate".equals(request.getParameter("action"))) {
                       
        } else if ("listspc".equals(request.getParameter("action"))) {
        	//           
        } else {
        	response.setContentType("application/json");
            List<SmartPhone> smartPhones = new ArrayList<>();
            for (SmartPhone p : metier.findAll()) {
            	smartPhones.add(new SmartPhone(p.getId(),p.getImei(), p.getUtilisateur()));
                
            }
            Gson json = new Gson();
            response.getWriter().write(json.toJson(smartPhones));
            
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
