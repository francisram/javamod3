package py.edu.ucsa.servlets;

import java.io.IOException;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import py.edu.ucsa.ejb.entities.Equipo;
import py.edu.ucsa.ejb.session.EquipoEjbRemote;


/**
 * Servlet implementation class EquipoServlet
 */
public class EquipoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(mappedName = "java:global/TorneoEjbApp/EquipoEjbImpl!py.edu.ucsa.ejb.session.EquipoEjbRemote")
	private EquipoEjbRemote equipoEbjbClient;

    /**
     * Default constructor. 
     */
    public EquipoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 List<Equipo> listaEquipos = (List<Equipo>) getServletContext().getAttribute("equipos");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("equipos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
