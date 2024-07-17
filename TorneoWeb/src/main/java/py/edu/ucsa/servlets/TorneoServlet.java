package py.edu.ucsa.servlets;

import java.io.IOException;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import py.edu.ucsa.ejb.entities.Torneo;
import py.edu.ucsa.ejb.services.TorneoEjbRemote;
import py.edu.ucsa.ejb.services.impl.TorneoEjbImpl;



/**
 * Servlet implementation class TorneoServlet
 */
public class TorneoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(mappedName = "java:global/TorneoEjbApp/TorneoEjbImpl!py.edu.ucsa.ejb.services.TorneoEjbRemote")
	private TorneoEjbRemote ejbcliente;

    /**
     * Default constructor. 
     */
    public TorneoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("torneo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
