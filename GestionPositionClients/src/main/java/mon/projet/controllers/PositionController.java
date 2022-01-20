package mon.projet.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import mon.projet.dao.PositionLocal;
import mon.projet.dao.SmartphoneLocal;
import mon.projet.entities.SmartPhone;

/**
 * Servlet implementation class PositionController
 */
@WebServlet("/PositionController")
public class PositionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PositionLocal metier;
	@EJB
	private SmartphoneLocal smartphone;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PositionController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ("phone".equals(request.getParameter("action"))) {
			String imei = (request.getParameter("id"));
			SmartPhone smartPhone = smartphone.findByEmei(imei);
			response.setContentType("application/json");

			Gson json = new Gson();
			response.getWriter().write(json.toJson(smartPhone));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
