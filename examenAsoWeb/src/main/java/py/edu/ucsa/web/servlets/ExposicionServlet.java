package py.edu.ucsa.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class ExposicionServlet
 */
@WebServlet(urlPatterns = { "/ExposicionServlet" })
public class ExposicionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExposicionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ParticExpoSocioDao participacionesDao = DaoFactory.getParticExpoSocioDao();
		ExposicionDao exposicionesDao = DaoFactory.getExposicionDao();
		if (Objects.isNull(request.getParameter("ACCION")) || "LISTAR".equals(request.getParameter("ACCION"))) {
			if (Objects.isNull(request.getParameter("FORMATO")) || "HTML".equals(request.getParameter("FORMATO"))) {
				List<Exposicion> exposiciones = exposicionesDao.listar();
				request.getSession().setAttribute("EXPOSICIONES", exposiciones);
				// System.out.println(exposiciones);
				request.getRequestDispatcher("listaExposiciones.jsp").forward(request, response);
			}
			if ("JSON".equals(request.getParameter("FORMATO"))) {
				Usuario user = new Usuario();
				user = (Usuario) request.getSession().getAttribute("SOCIO_CONECTADO");
				response.setContentType("application/json");
				System.out.println("llego pedido por json");
				List<Exposicion> exposiciones = exposicionesDao.listar();
			
				ParticExpoSocioImpl participacion = new ParticExpoSocioImpl();
				
				List<ParticExpoSocio> listadoPorSocio = participacion
						.obtenerParticipacionesPorSocio(user.getIdSocio().getId());
			
				
				JSONArray newArray = new JSONArray();

				for (Exposicion exposicion : exposiciones) {
				    boolean encontrado = false;

				    for (ParticExpoSocio particExpoSocio : listadoPorSocio) {
				        if (exposicion.getId() == particExpoSocio.getExposicion().getId()) {
				            encontrado = true;

				            JSONObject jsonObj = new JSONObject();
				            jsonObj.put("id", exposicion.getId());
				            jsonObj.put("nombre", exposicion.getNombre());
				            jsonObj.put("descripcion", exposicion.getDescripcion());
				            jsonObj.put("organiza", exposicion.getOrganiza());
				            jsonObj.put("ubicacion", exposicion.getUbicacion());   
				            jsonObj.put("fechaExpo", exposicion.getFechaExpo().toString());
				            jsonObj.put("contacto", exposicion.getContacto());
				            jsonObj.put("fechaCreacion", exposicion.getFechaCreacion());
				            jsonObj.put("usuarioCreacion", exposicion.getUsuarioCreacion());
				            jsonObj.put("activo", particExpoSocio.isCanceloParticipacion() ? 0 : 1);

				            newArray.add(jsonObj);
				            break; //
				        }
				    }

				    if (!encontrado) {
				        JSONObject jsonObj = new JSONObject();
				        jsonObj.put("id", exposicion.getId());
				        jsonObj.put("nombre", exposicion.getNombre());
				        jsonObj.put("descripcion", exposicion.getDescripcion());
				        jsonObj.put("organiza", exposicion.getOrganiza());
				        jsonObj.put("ubicacion", exposicion.getUbicacion());
				        jsonObj.put("fechaExpo", exposicion.getFechaExpo().toString());
				        jsonObj.put("contacto", exposicion.getContacto());
				        jsonObj.put("fechaCreacion", exposicion.getFechaCreacion());
				        jsonObj.put("usuarioCreacion", exposicion.getUsuarioCreacion());
				        jsonObj.put("activo", 0);

				        newArray.add(jsonObj);
				    }
				}


				//System.out.println("original--> "+ JSONArray.fromObject(exposiciones));
				//System.out.println("nuevo--> "+ newArray);
				response.getWriter().print(newArray);

			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("llego pedido json con parametros");
		Usuario user = new Usuario();
		BufferedReader reader = request.getReader();
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		Gson gson = new Gson();
		JsonObject jsonObject = gson.fromJson(sb.toString(), JsonObject.class);
		String inicio = jsonObject.get("inicio").getAsString();
		String fin = jsonObject.get("fin").getAsString();
		System.out.println("inicio : " + inicio);
		System.out.println("fin : " + fin);
		List<Exposicion> exposiciones = DaoFactory.getExposicionDao().listarPorFechas(inicio,fin);
		System.out.println(exposiciones);
		JSONArray newArray = new JSONArray();
		ParticExpoSocioImpl participacion = new ParticExpoSocioImpl();
		user = (Usuario) request.getSession().getAttribute("SOCIO_CONECTADO");
		List<ParticExpoSocio> listadoPorSocio = participacion
				.obtenerParticipacionesPorSocio(user.getIdSocio().getId());

		for (Exposicion exposicion : exposiciones) {
		    boolean encontrado = false;

		    for (ParticExpoSocio particExpoSocio : listadoPorSocio) {
		        if (exposicion.getId() == particExpoSocio.getExposicion().getId()) {
		            encontrado = true;

		            JSONObject jsonObj = new JSONObject();
		            jsonObj.put("id", exposicion.getId());
		            jsonObj.put("nombre", exposicion.getNombre());
		            jsonObj.put("descripcion", exposicion.getDescripcion());
		            jsonObj.put("organiza", exposicion.getOrganiza());
		            jsonObj.put("ubicacion", exposicion.getUbicacion());   
		            jsonObj.put("fechaExpo", exposicion.getFechaExpo().toString());
		            jsonObj.put("contacto", exposicion.getContacto());
		            jsonObj.put("fechaCreacion", exposicion.getFechaCreacion());
		            jsonObj.put("usuarioCreacion", exposicion.getUsuarioCreacion());
		            jsonObj.put("activo", particExpoSocio.isCanceloParticipacion() ? 0 : 1);

		            newArray.add(jsonObj);
		            break; //
		        }
		    }

		    if (!encontrado) {
		        JSONObject jsonObj = new JSONObject();
		        jsonObj.put("id", exposicion.getId());
		        jsonObj.put("nombre", exposicion.getNombre());
		        jsonObj.put("descripcion", exposicion.getDescripcion());
		        jsonObj.put("organiza", exposicion.getOrganiza());
		        jsonObj.put("ubicacion", exposicion.getUbicacion());
		        jsonObj.put("fechaExpo", exposicion.getFechaExpo().toString());
		        jsonObj.put("contacto", exposicion.getContacto());
		        jsonObj.put("fechaCreacion", exposicion.getFechaCreacion());
		        jsonObj.put("usuarioCreacion", exposicion.getUsuarioCreacion());
		        jsonObj.put("activo", 0);

		        newArray.add(jsonObj);
		    }
		}
		
		response.setContentType("application/json");
		response.getWriter().print(newArray);
	}

}