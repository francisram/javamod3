package py.edu.ucsa.web.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import py.edu.ucsa.ejb.dto.ExposicionDTO;
import py.edu.ucsa.ejb.entities.Exposicion;
import py.edu.ucsa.ejb.entities.ParticExpoSocio;
import py.edu.ucsa.ejb.entities.Usuario;
import py.edu.ucsa.ejb.services.ExposicionEjbRemote;
import py.edu.ucsa.ejb.services.ParticExpoSocioEjbRemote;

/**
 * Servlet implementation class ExposicionServlet
 */
@WebServlet(urlPatterns = { "/ExposicionServlet" })
public class ExposicionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB(mappedName = "java:global/AsoWebJPA-0.0.1/ExposicionEjbImpl!py.edu.ucsa.ejb.services.ExposicionEjbRemote")
	private ExposicionEjbRemote exposicionEjbRemote;

	@EJB(mappedName = "java:global/AsoWeb-0.0.1/ParticExpoSocioEjbImpl!py.edu.ucsa.ejb.services.ParticExpoSocioEjbRemote")
	private ParticExpoSocioEjbRemote particExpoSocioEjbRemote;

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
		System.out.println("llegamos al exposicion servlet");
		// ParticExpoSocioDao participacionesDao = DaoFactory.getParticExpoSocioDao();
		// ExposicionDao exposicionesDao = DaoFactory.getExposicionDao();
		if (Objects.isNull(request.getParameter("ACCION")) || "LISTAR".equals(request.getParameter("ACCION"))) {
			if (Objects.isNull(request.getParameter("FORMATO")) || "HTML".equals(request.getParameter("FORMATO"))) {
				try {
					List<ExposicionDTO> exposiciones = exposicionEjbRemote.findAll();
					request.getSession().setAttribute("EXPOSICIONES", exposiciones);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// System.out.println(exposiciones);
				request.getRequestDispatcher("listaExposiciones.jsp").forward(request, response);
			}
			if ("JSON".equals(request.getParameter("FORMATO"))) {
				Usuario user = new Usuario();
				user = (Usuario) request.getSession().getAttribute("SOCIO_CONECTADO");
				response.setContentType("application/json");
				System.out.println("llego pedido por json");
				try {
				List<ExposicionDTO> exposiciones = exposicionEjbRemote.findAll();
					// ParticExpoSocioImpl participacion = new ParticExpoSocioImpl();
					// List<ParticExpoSocio> listadoPorSocio =
					// participacion.obtenerParticipacionesPorSocio(user.getIdSocio().getId());
					Iterable<ParticExpoSocio> listadoPorSocio = particExpoSocioEjbRemote
							.obtenerParticipacionesPorSocio(user.getIdSocio());
					;

					JsonArray newArray = new JsonArray();

					for (ExposicionDTO exposicion : exposiciones) {
						boolean encontrado = false;

						for (ParticExpoSocio particExpoSocio : listadoPorSocio) {
							if (exposicion.getId() == particExpoSocio.getId()) {
								encontrado = true;
								JsonObject jsonObj = new JsonObject();
								jsonObj.addProperty("id", exposicion.getId());
								jsonObj.addProperty("nombre", exposicion.getNombre());
								jsonObj.addProperty("descripcion", exposicion.getDescripcion());
								jsonObj.addProperty("organiza", exposicion.getOrganiza());
								jsonObj.addProperty("ubicacion", exposicion.getUbicacion());
								jsonObj.addProperty("fechaExpo", exposicion.getFechaExpo().toString());
								jsonObj.addProperty("contacto", exposicion.getContacto());
								jsonObj.addProperty("fechaCreacion", exposicion.getFechaCreacion().toString());
								jsonObj.addProperty("usuarioCreacion", exposicion.getUsuarioCreacion().toString());
								jsonObj.addProperty("activo", particExpoSocio.isCanceloParticipacion() ? 0 : 1);
								newArray.add(jsonObj);
								break; //
							}
						}

						if (!encontrado) {
							JsonObject jsonObj = new JsonObject();
							jsonObj.addProperty("id", exposicion.getId());
							jsonObj.addProperty("nombre", exposicion.getNombre());
							jsonObj.addProperty("descripcion", exposicion.getDescripcion());
							jsonObj.addProperty("organiza", exposicion.getOrganiza());
							jsonObj.addProperty("ubicacion", exposicion.getUbicacion());
							jsonObj.addProperty("fechaExpo", exposicion.getFechaExpo().toString());
							jsonObj.addProperty("contacto", exposicion.getContacto());
							jsonObj.addProperty("fechaCreacion", exposicion.getFechaCreacion().toString());
							jsonObj.addProperty("usuarioCreacion", exposicion.getUsuarioCreacion().toString());
							jsonObj.addProperty("activo", 0);

							newArray.add(jsonObj);
						}
					}
					response.getWriter().print(newArray);
				} catch (Exception e) {
					e.printStackTrace();				}

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
		Iterable<ExposicionDTO> exposiciones = exposicionEjbRemote.listarPorFechas(inicio, fin);
		System.out.println(exposiciones);
		JsonArray newArray = new JsonArray();
		// ParticExpoSocioImpl participacion = new ParticExpoSocioImpl();
		user = (Usuario) request.getSession().getAttribute("SOCIO_CONECTADO");
		// List<ParticExpoSocio> listadoPorSocio =
		// participacion.obtenerParticipacionesPorSocio(user.getIdSocio().getId());
		Iterable<ParticExpoSocio> listadoPorSocio = particExpoSocioEjbRemote
				.obtenerParticipacionesPorSocio(user.getIdSocio());

		for (ExposicionDTO exposicion : exposiciones) {
			boolean encontrado = false;

			for (ParticExpoSocio particExpoSocio : listadoPorSocio) {
				if (exposicion.getId() == particExpoSocio.getExposicion().getId()) {
					encontrado = true;

					JsonObject jsonObj = new JsonObject();
					jsonObj.addProperty("id", exposicion.getId());
					jsonObj.addProperty("nombre", exposicion.getNombre());
					jsonObj.addProperty("descripcion", exposicion.getDescripcion());
					jsonObj.addProperty("organiza", exposicion.getOrganiza());
					jsonObj.addProperty("ubicacion", exposicion.getUbicacion());
					jsonObj.addProperty("fechaExpo", exposicion.getFechaExpo().toString());
					jsonObj.addProperty("contacto", exposicion.getContacto());
					jsonObj.addProperty("fechaCreacion", exposicion.getFechaCreacion().toString());
					jsonObj.addProperty("usuarioCreacion", exposicion.getUsuarioCreacion().toString());
					jsonObj.addProperty("activo", particExpoSocio.isCanceloParticipacion() ? 0 : 1);

					newArray.add(jsonObj);
					break; //
				}
			}

			if (!encontrado) {
				JsonObject jsonObj = new JsonObject();
				jsonObj.addProperty("id", exposicion.getId());
				jsonObj.addProperty("nombre", exposicion.getNombre());
				jsonObj.addProperty("descripcion", exposicion.getDescripcion());
				jsonObj.addProperty("organiza", exposicion.getOrganiza());
				jsonObj.addProperty("ubicacion", exposicion.getUbicacion());
				jsonObj.addProperty("fechaExpo", exposicion.getFechaExpo().toString());
				jsonObj.addProperty("contacto", exposicion.getContacto());
				jsonObj.addProperty("fechaCreacion", exposicion.getFechaCreacion().toString());
				jsonObj.addProperty("usuarioCreacion", exposicion.getUsuarioCreacion().toString());
				jsonObj.addProperty("activo", 0);

				newArray.add(jsonObj);
			}
		}

		response.setContentType("application/json");
		response.getWriter().print(newArray);
	}

}
