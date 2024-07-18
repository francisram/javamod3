package py.edu.ucsa.servlets;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
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
import py.edu.ucsa.ejb.services.JugadorEjbRemote;

/**
 * Servlet implementation class JugadorServlet
 */
public class JugadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB(mappedName = "java:global/TorneoEjbApp/JugadorEjbImpl!py.edu.ucsa.ejb.services.JugadorEjbRemote")
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

		 request.getRequestDispatcher("jugadores.jsp").forward(request, response);
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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
				System.out.println("llego pedido de listar jugadores");
				List<JugadorDTO> jugadores = jugadorRemote.findAll();
				System.out.println(jugadores.toString());
				Gson gsonList = new Gson();
				String jugadoresJson = gsonList.toJson(jugadores);
				// Establecer el tipo de contenido de la respuesta a JSON
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				// Escribir el JSON en la respuesta
				PrintWriter out = response.getWriter();
				out.write(jugadoresJson);
				out.flush();
			}
			if ("listarLosSinEquipo".equals(accion)) {
				//System.out.println("llego pedido de listar jugadores");
				List<JugadorDTO> jugadores = jugadorRemote.findJugadoresSinEquipo();
				System.out.println(jugadores.toString());
				Gson gsonList = new Gson();
				String jugadoresJson = gsonList.toJson(jugadores);
				// Establecer el tipo de contenido de la respuesta a JSON
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				// Escribir el JSON en la respuesta
				PrintWriter out = response.getWriter();
				out.write(jugadoresJson);
				out.flush();
			}

			// registrar
			if ("inscribir".equals(accion)) {

				JugadorDTO jugador = new JugadorDTO();
				jugador.setNombres(jsonObject.get("nombre").getAsString());
				jugador.setApellidos(jsonObject.get("apellido").getAsString());
				jugador.setNroFicha(Integer.parseInt(jsonObject.get("ficha").getAsString()));
				jugador.setEmail(jsonObject.get("email").getAsString());
				jugador.setFechaNacimiento(jsonObject.get("fecnac").getAsString());
				jugador.setTelefono(jsonObject.get("telefono").getAsString());
				jugador.setNacionalidad(jsonObject.get("pais").getAsString());
				jugadorRemote.insert(jugador);
				JsonObject responseJson = new JsonObject();
				responseJson.addProperty("status", "ok");
				// Enviar la respuesta
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(responseJson.toString());
				// request.getRequestDispatcher("equipos.jsp").forward(request, response);
			}
			if ("borrar".equals(accion)) {
				//JugadorDTO jugador = new JugadorDTO();
				Long id = jsonObject.get("id").getAsLong();
				System.out.println(id);
				jugadorRemote.eliminar(id);
				JsonObject responseJson = new JsonObject();
				responseJson.addProperty("status", "ok");
				// Enviar la respuesta
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
			// return;
		}
	}

}
