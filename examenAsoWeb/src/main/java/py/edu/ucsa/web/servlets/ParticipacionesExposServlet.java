package py.edu.ucsa.web.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import py.edu.ucsa.ejb.entities.Exposicion;
import py.edu.ucsa.ejb.entities.ParticExpoSocio;
import py.edu.ucsa.ejb.entities.Socio;
import py.edu.ucsa.ejb.entities.Usuario;
import py.edu.ucsa.ejb.services.ExposicionEjbRemote;
import py.edu.ucsa.ejb.services.ParticExpoSocioEjbRemote;
import py.edu.ucsa.ejb.services.UsuarioEjbRemote;


/**
 * Servlet implementation class ParticipacionesExposServlet
 */
@WebServlet(urlPatterns = { "/ParticipacionesExposServlet" })
public class ParticipacionesExposServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(mappedName = "java:global/AsoWebJPA-0.0.1/ParticExpoSocioEjbImpl!py.edu.ucsa.ejb.services.ParticExpoSocioEjbRemote")
	private ParticExpoSocioEjbRemote particExpoSocioEjbRemote;
	
	@EJB(mappedName = "java:global/AsoWebJPA-0.0.1/UsuarioEjbImpl!py.edu.ucsa.ejb.services.UsuarioEjbRemote")
	private UsuarioEjbRemote usuarioEjbClient;
	
	@EJB(mappedName = "java:global/AsoWebJPA-0.0.1/ExposicionEjbImpl!py.edu.ucsa.ejb.services.ExposicionEjbRemote")
	private ExposicionEjbRemote exposicionEjbRemote;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ParticipacionesExposServlet() {
		super();
		// TODO Auto-generated constructor stub
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
			JsonArray valores = jsonObject.getAsJsonArray("valores");
			JsonArray valoresActualizados = new JsonArray();
			String accion = jsonObject.get("accion").getAsString();
			Usuario  user = new Usuario();
			user = (Usuario) request.getSession().getAttribute("SOCIO_CONECTADO");
			LocalDateTime fechaActual = LocalDateTime.now();

			if ("inscribir".equals(accion)) {
				for (JsonElement elemento : valores) {
					JsonObject object = elemento.getAsJsonObject();
					//System.out.println(object);
					int id = object.get("id").getAsInt();
					String nombre = object.get("nombre").getAsString();
					Exposicion expo = new Exposicion();
					expo.setId(id);
					expo.setNombre(nombre);
					ParticExpoSocio pExpo = new ParticExpoSocio();
					pExpo.setCanceloParticipacion(false);
					pExpo.setExposicion(expo);
					pExpo.setFechaCreacion(fechaActual);
					pExpo.setFechaCancelacion(fechaActual);
					pExpo.setUsuarioCreacion(user);
					pExpo.setSocio(user.getIdSocio());
					// verificamos si ya existe el registro
					ParticExpoSocio participa = new ParticExpoSocio();
					//participa = pExpoImpl.ObtenerParticipacion(pExpo.getExposicion().getId(), pExpo.getSocio().getId());
					participa = particExpoSocioEjbRemote.ObtenerParticipacion(pExpo.getExposicion(), pExpo.getSocio());
					System.out.println("participacion : " + participa);
					// antes de registrar vamos a verificar que hacer con el
					String queHacer = validarSiActualizarRegistrarSaltar(participa);
					//System.out.println(queHacer);
					if ("actualizar".equals(queHacer)) {
						// hay que actualizar
						pExpo.setId(participa.getId());
						actualizarParticipacion(pExpo);
						valoresActualizados.add(elemento);
					}
					if ("registrar".equals(queHacer)) {
						registrarParticipacion(pExpo);
						valoresActualizados.add(elemento);
					}
				}
			}
			if ("cancelar".equals(accion)) {
				for (JsonElement elemento : valores) {
					JsonObject object = elemento.getAsJsonObject();
					int id = object.get("id").getAsInt();
					String nombre = object.get("nombre").getAsString();
					Exposicion expo = new Exposicion();
					expo.setId(id);
					expo.setNombre(nombre);
					ParticExpoSocio pExpo = new ParticExpoSocio();
					pExpo.setCanceloParticipacion(true);
					pExpo.setExposicion(expo);
					pExpo.setFechaCreacion(fechaActual);
					pExpo.setFechaCancelacion(fechaActual);
					pExpo.setUsuarioCreacion(user);
					pExpo.setSocio(user.getIdSocio());
					// verificamos si ya existe el registro
					ParticExpoSocio participa = new ParticExpoSocio();
					//participa = pExpoImpl.ObtenerParticipacion(pExpo.getExposicion().getId(), pExpo.getSocio().getId());
					participa = particExpoSocioEjbRemote.ObtenerParticipacion(pExpo.getExposicion(), pExpo.getSocio());
					// antes de registrar vamos a verificar que hacer con el
					String queHacer = validarSiCancelarSaltar(participa);
					//System.out.println(queHacer);
					if ("actualizar".equals(queHacer)) {
						// hay que actualizar
						pExpo.setId(participa.getId());
						actualizarParticipacion(pExpo);
						valoresActualizados.add(elemento);
					}
				}
			}

			JsonObject responseJson = new JsonObject();
			responseJson.addProperty("status", "ok");
			System.out.println(valoresActualizados);
			responseJson.add("valoresActualizados", valoresActualizados);

			// Enviar la respuesta
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(responseJson.toString());
		} catch (Exception e) {
			// Manejar el error y enviar una respuesta de error al cliente
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("error");
			e.printStackTrace(); // Puedes imprimir la traza de la excepción para depuración
		}
	}

	public void actualizarParticipacion(ParticExpoSocio participacion) {
		try {
			//ParticExpoSocioImpl pExpoImpl = new ParticExpoSocioImpl();
			//pExpoImpl.modificar(participacion);
			particExpoSocioEjbRemote.actualizar(participacion.toDTO());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void registrarParticipacion(ParticExpoSocio participacion) {
		try {
			System.out.println("se debe registrar");
			System.out.println(participacion);
			particExpoSocioEjbRemote.insert(participacion.toDTO());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public String validarSiActualizarRegistrarSaltar(ParticExpoSocio p) {
		String realizar = "";
		try {
			if (p.getId() != null) {
				if (p.isCanceloParticipacion() == true) {
					realizar = "actualizar";
				} else {
					realizar = "saltar";
				}
			} else {
				realizar = "registrar";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return realizar;
	}

	public String validarSiCancelarSaltar(ParticExpoSocio p) {
		String realizar = "";
		try {
			if (p.isCanceloParticipacion() == false) {
				realizar = "actualizar";
			} else {
				realizar = "saltar";
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return realizar;
	}
}
