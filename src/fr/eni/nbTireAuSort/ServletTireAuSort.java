package fr.eni.nbTireAuSort;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTireAuSort
 */
//@WebServlet("/ServletTireAuSort")
public class ServletTireAuSort extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// déclaration des variables
	private int nbalea;
	private boolean dejaTrouve;
	
	
	//point d'entrée dans le servlet : que quand la servlet est crée
	@Override
	public void init() throws ServletException {
		
		//mise en place du paramètre
		int nbSup = 10;
		int nbInf = 0;
			try {
				nbInf = Integer.parseInt(getInitParameter("BORNE_INF"));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			try {
				nbSup = Integer.parseInt(getInitParameter("BORNE_SUP"));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			
		//tirage au sort d'un nb entre 0 et 10
			
				System.out.println(nbInf);
				System.out.println(nbSup);
		nbalea = new Random().nextInt(nbSup +1)+nbInf;
		System.out.println(nbalea);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nbre;
		//recupère la valeur name="nb" de index.html
		String nb = request.getParameter("nb");
		System.out.println(nb);
		try {
			//passage en int et levée d'exception
			nbre = Integer.parseInt(nb);
			//si la valeur de nbre est égal à la valeur du nombre alea et si pas trouvée
			if(nbre == nbalea && dejaTrouve == false) {
				dejaTrouve = true;
				// renvoie vers la page victoire
				response.sendRedirect("victoire.html");
			}else {
				//renvoie vers la page echec
				response.sendRedirect("echec.html");
			}
		} catch (NumberFormatException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

}
