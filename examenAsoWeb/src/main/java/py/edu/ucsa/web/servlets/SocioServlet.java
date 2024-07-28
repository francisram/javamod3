package py.edu.ucsa.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Servlet implementation class SocioServlet
 */
@WebServlet(urlPatterns = { "/socio-servlet" })
public class SocioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SocioServlet() {
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
		SocioDao socioDao = DaoFactory.getSocioDao();
		if (Objects.isNull(request.getParameter("ACCION")) || "".equals(request.getParameter("ACCION"))
				|| "LISTAR".equals(request.getParameter("ACCION"))) {
			System.out.println("ENTRE MAAL");
			if (request.getSession().getAttribute("SOCIOS") == null) {
				request.getSession().setAttribute("SOCIOS", socioDao.listar());
			}
			request.getRequestDispatcher("listar-socios.jsp").forward(request, response);
		} else if ("NUEVO".equals(request.getParameter("ACCION"))) {
			System.out.println("NUEVO SOCIO");

			if (request.getSession().getAttribute("SOCIOS") == null) {
				request.getSession().setAttribute("SOCIOS", socioDao.listar());
			}

			if (request.getSession().getAttribute("TIPOS") == null) {
				List<Opcion> tiposSocios = DaoFactory.getOpcionDao().getOpcionesByCodDominio("tipsoc");
				System.out.println("tipos socios:  " + tiposSocios);
				request.getSession().setAttribute("TIPOS", tiposSocios);
			}

			if (request.getSession().getAttribute("ESTADOS") == null) {
				List<Opcion> estadosSocios = DaoFactory.getOpcionDao().getOpcionesByCodDominio("ESTSOC");
				System.out.println("estados socios : " + estadosSocios);
				request.getSession().setAttribute("ESTADOS", estadosSocios);
			}
			request.getRequestDispatcher("abmSocio.jsp").forward(request, response);
		} else if ("INSERTAR".equals(request.getParameter("ACCION"))) {
			System.out.println("VAMOS A INSERTAR EL NUEVO SOCIO");
			Socio nuevo = new Socio();
			nuevo.setNombres(request.getParameter("nombres-socio"));
			nuevo.setApellidos(request.getParameter("apellidos-socio"));
			socioDao.insertar(nuevo);
			request.setAttribute("MENSAJE", "EL SOCIO HA SIDO GUARDADO CON ÉXITO");
			request.getSession().setAttribute("SOCIOS", socioDao.listar());
			request.getRequestDispatcher("listar-socios.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ystem.out.println(request.getParameter("nombres"));
		SocioDaoImpl sDao = new SocioDaoImpl();
		Socio socioDto = new Socio();

		// TODO Auto-generated method stub
		//PrintWriter pw = response.getWriter();
		//pw.print("<html><head><title> Mostrar Parametros </title><head>");
		//pw.print("<body><h1> Parametro </h1><hr>");
		if (Objects.nonNull(request.getParameter("nombres"))) {
			socioDto.setNombres(request.getParameter("nombres"));
		//	pw.print("<br> nombres: " + request.getParameter("nombres"));
		}

		if (Objects.nonNull(request.getParameter("apellidos"))) {
			socioDto.setApellidos(request.getParameter("apellidos"));
		//	pw.print("<br> apellidos: " + request.getParameter("apellidos"));
		}

		if (Objects.nonNull(request.getParameter("email"))) {
			socioDto.setEmail(request.getParameter("email"));
			//pw.print("<br> email: " + request.getParameter("email"));
		}

		if (Objects.nonNull(request.getParameter("nro_socio"))) {
			socioDto.setNroSocio(Integer.parseInt(request.getParameter("nro_socio")));
			//pw.print("<br> nro_socio: " + request.getParameter("nro_socio"));
		}

		if (Objects.nonNull(request.getParameter("nro_cedula"))) {
			socioDto.setNroCedula(Integer.parseInt(request.getParameter("nro_cedula")));
			//pw.print("<br> nro_cedula: " + request.getParameter("nro_cedula"));
		}

		if (Objects.nonNull(request.getParameter("fecha_ingreso"))) {
			//pw.print("<br> fecha_ingreso: " + request.getParameter("fecha_ingreso"));
		}

		if (Objects.nonNull(request.getParameter("id_estado_actual"))) {
			Opcion estado = new Opcion(Integer.valueOf(request.getParameter("id_estado_actual")));
			socioDto.setEstadoActual(estado);
			//pw.print("<br> id_estado_actual: " + request.getParameter("id_estado_actual"));
		}

		if (Objects.nonNull(request.getParameter("fecha_estado_actual"))) {
			//pw.print("<br> fecha_estado_actual: " + request.getParameter("fecha_estado_actual"));
		}

		LocalDate ahora = LocalDate.now();
		socioDto.setFecha_creacion(ahora);
		socioDto.setFechaEstadoActual(ahora);
		socioDto.setFechaIngreso(LocalDate.of(2023, 8, 20));
		if (Objects.nonNull(request.getParameter("fundador")) && "on".equals(request.getParameter("fundador"))) {
			//pw.print("<br> fundador: " + request.getParameter("fundador"));
			socioDto.setFundador(true);
		} else {
			socioDto.setFundador(false);
		}

		if (Objects.nonNull(request.getParameter("id_usuario_creacion"))) {
			//pw.print("<br> id_usuario_creacion: " + request.getParameter("id_usuario_creacion"));
			Usuario usuario = new Usuario(Integer.parseInt(request.getParameter("id_usuario_creacion")));
			socioDto.setUsuarioCreacion(usuario);
		}

		if (Objects.nonNull(request.getParameter("fecha_creacion"))) {
			//pw.print("<br> fecha_creacion: " + request.getParameter("fecha_creacion"));
			LocalDate fechaCreacion = LocalDate.parse(request.getParameter("fecha_creacion"));
			socioDto.setFecha_creacion(fechaCreacion);
		}

		if (Objects.nonNull(request.getParameter("id_socio_proponente"))) {
			//pw.print("<br> id_socio_proponente: " + request.getParameter("id_socio_proponente"));
			Socio proponente = new Socio(Integer.parseInt(request.getParameter("id_socio_proponente")));
			socioDto.setSocioProponente(proponente);
		}

		if (Objects.nonNull(request.getParameter("id_tipo_socio"))) {
			//pw.print("<br> id_tipo_socio: " + request.getParameter("id_tipo_socio"));
			Opcion opcion = new Opcion(Integer.parseInt(request.getParameter("id_tipo_socio")));
			socioDto.setTipoSocio(opcion);
		}

		try {
			sDao.insertar(socioDto);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		//pw.print("</body></html>");
		response.sendRedirect(request.getContextPath() + "/socio-servlet");

	}

}
