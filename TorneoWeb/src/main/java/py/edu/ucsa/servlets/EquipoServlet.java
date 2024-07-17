package py.edu.ucsa.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import py.edu.ucsa.ejb.dto.EquipoDTO;
import py.edu.ucsa.ejb.dto.JugadorDTO;
import py.edu.ucsa.ejb.services.EquipoEjbRemote;
import py.edu.ucsa.ejb.services.JugadorEjbRemote;

/**
 * Servlet implementation class EquipoServlet
 */
public class EquipoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB(mappedName = "java:global/TorneoEjbApp/EquipoEjbImpl!py.edu.ucsa.ejb.services.EquipoEjbRemote")
	private EquipoEjbRemote equipoEbjbClient;
	
	@EJB(mappedName = "java:global/TorneoEjbApp/JugadorEjbImpl!py.edu.ucsa.ejb.services.JugadorEjbRemote")
	private JugadorEjbRemote jugadorRemote;

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

		request.getRequestDispatcher("equipos.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			BufferedReader reader = request.getReader();
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}

			Gson gson = new Gson();
			JsonObject jsonObject = gson.fromJson(sb.toString(), JsonObject.class);
			String accion = jsonObject.get("accion").getAsString();
			//System.out.println(accion);
			// listar
			if ("listar".equals(accion)) {
				//System.out.println("llego pedido de listar equipos");
				List<EquipoDTO> equipos = equipoEbjbClient.findAll();
				//System.out.println(equipos.toString());
				Gson gsonList = new Gson();
				String equiposJson = gsonList.toJson(equipos);
				// Establecer el tipo de contenido de la respuesta a JSON
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				// Escribir el JSON en la respuesta
				PrintWriter out = response.getWriter();
				out.write(equiposJson);
				out.flush();
			}

			// registrar
			if ("inscribir".equals(accion)) {
				EquipoDTO equipo = new EquipoDTO();
				equipo.setNombre(jsonObject.get("teamName").getAsString());
				equipo.setSlogan(jsonObject.get("slogan").getAsString());
				JugadorDTO capitan = new JugadorDTO();
				if(!Objects.isNull(jsonObject.get("capitan"))) {					
					capitan.setId(jsonObject.get("capitan").getAsLong());
					equipo.setCapitan(capitan);
				}
				
				//jsonObject.getAsJsonArray("jugadores");
				JsonArray jugadoresArray = jsonObject.getAsJsonArray("jugadores");
				List<JugadorDTO> jugadores = new ArrayList<JugadorDTO>();
				for (int i = 0; i < jugadoresArray.size(); i++) {
					JugadorDTO j = 	jugadorRemote.getById(jugadoresArray.get(i).getAsLong());
					jugadores.add(j);
					//System.out.println(j);
				}	
				equipo.setJugadores(jugadores);
				equipoEbjbClient.insert(equipo);
				JsonObject responseJson = new JsonObject();
				responseJson.addProperty("status", "ok");
				// Enviar la respuesta
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(responseJson.toString());
			//	request.getRequestDispatcher("equipos.jsp").forward(request, response);
			}
			if ("borrar".equals(accion)) {
				//EquipoDTO equipo = new EquipoDTO();
				Long id = jsonObject.get("id").getAsLong();
				System.out.println(id);
				equipoEbjbClient.eliminar(id);
				JsonObject responseJson = new JsonObject();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(responseJson.toString());
				// request.getRequestDispatcher("equipos.jsp").forward(request, response);
			}
		} catch (Exception e) {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			JsonObject errorJson = new JsonObject();
			errorJson.addProperty("status", "error");
			errorJson.addProperty("message", e.getMessage());
			response.getWriter().write(errorJson.toString());
			e.printStackTrace();
		//	return;
		}

		// doGet(request, response);
	}

}
