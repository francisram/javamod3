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
import py.edu.ucsa.ejb.dto.PartidoDTO;
import py.edu.ucsa.ejb.entities.Equipo;
import py.edu.ucsa.ejb.services.EquipoEjbRemote;
import py.edu.ucsa.ejb.services.PartidoEjbRemote;



/**
 * Servlet implementation class PartidoServlet
 */
public class PartidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(mappedName = "java:global/TorneoEjbApp/PartidoEjbImpl!py.edu.ucsa.ejb.services.PartidoEjbRemote")
	private PartidoEjbRemote partidoEjbClient;
	
	@EJB(mappedName = "java:global/TorneoEjbApp/EquipoEjbImpl!py.edu.ucsa.ejb.services.EquipoEjbRemote")
	private EquipoEjbRemote equipoEbjbClient;

    /**
     * Default constructor. 
     */
    public PartidoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.getRequestDispatcher("partidos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		//	System.out.println(jsonObject.toString());
			// listar
			if ("listar".equals(accion)) {
				//System.out.println("llego pedido de listar equipos");
				List<PartidoDTO> partidos = partidoEjbClient.findAll();
				//System.out.println(partidos.toString());
				Gson gsonList = new Gson();
				String equiposJson = gsonList.toJson(partidos);
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
				PartidoDTO partido = new PartidoDTO();
				EquipoDTO local = equipoEbjbClient.getById(Long.parseLong(jsonObject.getAsJsonObject("equipoLocal").get("id").getAsString()));  
				EquipoDTO visitante = equipoEbjbClient.getById(Long.parseLong(jsonObject.getAsJsonObject("equipoVisitante").get("id").getAsString()));  
				
				//System.out.println(equipo);
				partido.setEquipoLocal(local);
				partido.setEquipoVisitante(visitante);
				partido.setFecha(jsonObject.get("fecha").getAsString());
				partido.setFechaNro(0);
				partido.setGoleLocal(0);
				partido.setGoleVisitante(0);
				partido.setHora(accion);
				partido.setTorneo(null);
				
				//partidoEjbClient.insert(partido);
				JsonObject responseJson = new JsonObject();
				responseJson.addProperty("status", "ok");
				// Enviar la respuesta
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(responseJson.toString());
			//	request.getRequestDispatcher("equipos.jsp").forward(request, response);
			}
			/*
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
			*/
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
	}

}
