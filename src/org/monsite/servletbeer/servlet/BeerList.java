package org.monsite.servletbeer.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.monsite.servletbeer.modele.Beer;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class BeerList
 */
@WebServlet("/BeerList")
public class BeerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeerList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// recheche de la liste au format java
		List<Beer> listeBiere = Beer.getBeers();
		// convertisseur java/json
		ObjectMapper mapper = new ObjectMapper();
		// convertit liste format java en json
		String jsonList = mapper.writeValueAsString(listeBiere);
		
		// envoi chaine json
		response.getWriter().append(jsonList);
		
		// url : http://localhost:8080/AngularBeers/BeerList
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
