package py.edu.ucsa.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import py.edu.ucsa.ejb.dto.TorneoDTO;
import py.edu.ucsa.ejb.entities.Torneo;
import py.edu.ucsa.ejb.services.TorneoEjbRemote;
import py.edu.ucsa.ejb.services.impl.TorneoEjbImpl;



/**
 * Servlet implementation class TorneoServlet
 */
public class TorneoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(mappedName = "java:global/TorneoEjbApp/TorneoEjbImpl!py.edu.ucsa.ejb.services.TorneoEjbRemote")
	private TorneoEjbRemote torneoEjbcliente;

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
				List<TorneoDTO> torneos = torneoEjbcliente.findAll();
				//System.out.println(equipos.toString());
				Gson gsonList = new Gson();
				String torneoJson = gsonList.toJson(torneos);
				// Establecer el tipo de contenido de la respuesta a JSON
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				// Escribir el JSON en la respuesta
				PrintWriter out = response.getWriter();
				out.write(torneoJson);
				out.flush();
			}
			// registrar
						if ("inscribir".equals(accion)) {
							TorneoDTO torneo = new TorneoDTO();
							torneo.setNombre(jsonObject.get("torneoName").getAsString());
							String thisYear = new SimpleDateFormat("yyyy").format(new Date());
							torneo.setAnho(thisYear);
							torneo.setNumEquipo(jsonObject.get("numEquipos").getAsInt());
							torneo.setFechaInicio(jsonObject.get("inicio").getAsString());
							torneo.setFechaFin(jsonObject.get("fin").getAsString());
							torneoEjbcliente.insert(torneo);
							JsonObject responseJson = new JsonObject();
							responseJson.addProperty("status", "ok");
							// Enviar la respuesta
							response.setContentType("application/json");
							response.setCharacterEncoding("UTF-8");
							response.getWriter().write(responseJson.toString());
						//	request.getRequestDispatcher("equipos.jsp").forward(request, response);
						}
			
			
		} catch (Exception e) {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			JsonObject errorJson = new JsonObject();
			errorJson.addProperty("status", "error");
			errorJson.addProperty("message", e.getMessage());
			response.getWriter().write(errorJson.toString());
			e.printStackTrace();
		}
	}

}
