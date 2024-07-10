package py.edu.ucsa.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import py.edu.ucsa.ejb.dto.EquipoDTO;
import py.edu.ucsa.ejb.dto.JugadorDTO;
import py.edu.ucsa.ejb.entities.Equipo;
import py.edu.ucsa.ejb.entities.Jugador;
import py.edu.ucsa.ejb.services.EquipoEjbRemote;
import py.edu.ucsa.ejb.services.impl.EquipoEjbImpl;

/**
 * Servlet implementation class EquipoServlet
 */
public class EquipoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB(mappedName = "java:global/TorneoEjbApp/EquipoEjbImpl!py.edu.ucsa.ejb.services.EquipoEjbRemote")
	private EquipoEjbRemote equipoEbjbClient;

	/**
	 * Default constructor.
	 */
	public EquipoServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
		try {
			BufferedReader reader = request.getReader();
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			String requestBody = sb.toString();
	        if (requestBody.isEmpty()) {
	            request.getRequestDispatcher("equipos.jsp").forward(request, response);
	            return;
	        }
			Gson gson = new Gson();
			JsonObject jsonObject = gson.fromJson(sb.toString(), JsonObject.class);
				
			String accion = jsonObject.get("accion").getAsString();
			if ("inscribir".equals(accion)) {
				
				EquipoDTO equipo = new EquipoDTO();
				equipo.setNombre(jsonObject.get("teamName").getAsString());
				equipo.setSlogan(jsonObject.get("slogan").getAsString());
				JugadorDTO j = new JugadorDTO();
				j.setNombres(jsonObject.get("capitan").getAsString());
				j.setId(1L);
				equipo.setCapitan(j);
				equipoEbjbClient.insert(equipo);
				JsonObject responseJson = new JsonObject();
				responseJson.addProperty("status", "ok");
				// Enviar la respuesta
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(responseJson.toString());
				request.getRequestDispatcher("equipos.jsp").forward(request, response);
				return;
			}
			
		} catch (Exception e) {
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    JsonObject errorJson = new JsonObject();
		    errorJson.addProperty("status", "error");
		    errorJson.addProperty("message", e.getMessage());
		    response.getWriter().write(errorJson.toString());
		    e.printStackTrace(); 
		    return;
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
