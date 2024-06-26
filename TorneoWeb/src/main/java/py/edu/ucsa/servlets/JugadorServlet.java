package py.edu.ucsa.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import py.edu.ucsa.ejb.entities.Jugador;
import py.edu.ucsa.ejb.session.JugadorEjbRemote;

/**
 * Servlet implementation class JugadorServlet
 */
public class JugadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB(mappedName = "java:global/TorneoEjbApp/JugadorEjbImpl!py.edu.ucsa.ejb.session.JugadorEjbRemote")
	private JugadorEjbRemote jugadorRemote;

	/**
	 * Default constructor.
	 */
	public JugadorServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (Objects.isNull(request.getParameter("ACCION")) || "LISTAR".equals(request.getParameter("ACCION"))) {
			ServletContext context = getServletContext();
			if (Objects.isNull(request.getParameter("FORMATO")) || "HTML".equals(request.getParameter("FORMATO"))) {
				@SuppressWarnings("unchecked")
				List<Jugador> jugadores = (List<Jugador>) context.getAttribute("jugadores");
				System.out.println(jugadores);
				request.getSession().setAttribute("JUGADORES", jugadores);
			//	request.getRequestDispatcher("jugadores.jsp").forward(request, response);
				request.getRequestDispatcher("jugadores.jsp").forward(request, response);
			}
			if ("JSON".equals(request.getParameter("FORMATO"))) {
				response.setContentType("application/json");
				System.out.println("llego pedido por json");
				List<Jugador> jugadores = (List<Jugador>) context.getAttribute("jugadores");
				 Gson gson = new Gson();
	                JsonArray jsonArray = new JsonArray();
	                for (Jugador jugador : jugadores) {
	                    JsonObject jsonObject = new JsonObject();
	                    jsonObject.addProperty("id", jugador.getId());
	                    jsonObject.addProperty("nombres", jugador.getNombres());
	                    jsonObject.addProperty("apellidos", jugador.getApellidos());
	                    jsonObject.addProperty("equipo", jugador.getEquipo().getNombre());
	                    jsonObject.addProperty("pais", jugador.getNacionalidad());
	                    jsonArray.add(jsonObject);
	                }
	                //JsonObject jsonResponse = new JsonObject();
	                //jsonResponse.add("data", jsonArray);

	                response.getWriter().print(gson.toJson(jsonArray));
			}
			
		}
		//request.getRequestDispatcher("jugadores.jsp").forward(request, response);
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
