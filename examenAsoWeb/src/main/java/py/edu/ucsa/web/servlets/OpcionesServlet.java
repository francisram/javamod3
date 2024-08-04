package py.edu.ucsa.web.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import py.edu.ucsa.ejb.dto.OpcionDTO;
import py.edu.ucsa.ejb.entities.Dominio;
import py.edu.ucsa.ejb.entities.Opcion;
import py.edu.ucsa.ejb.services.DominioEjbRemote;
import py.edu.ucsa.ejb.services.OpcionEjbRemote;

/**
 * Servlet implementation class Opciones
 */
@WebServlet(urlPatterns = { "/Opciones-servlet" })
public class OpcionesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(mappedName = "")
	private OpcionEjbRemote opcionEjbRemote;
	
	@EJB(mappedName = "")
	private DominioEjbRemote dominioEjbRemote;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OpcionesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//OpcionDao opcionesDao = DaoFactory.getOpcionDao();
		//DominioDao dominios = DaoFactory.getDominioDao();
		if (Objects.isNull(request.getParameter("ACCION")) || "".equals(request.getParameter("ACCION"))
				|| "LISTAR".equals(request.getParameter("ACCION"))) {
			if(Objects.isNull(request.getParameter("FORMATO")) || "HTML".equals(request.getParameter("FORMATO"))) {
				request.getSession().setAttribute("OPCIONES", opcionEjbRemote.listar());
				request.getSession().setAttribute("DOMINIOS", dominioEjbRemote.listar());
				request.getRequestDispatcher("opciones.jsp").forward(request, response);
			}
			if("JSON".equals(request.getParameter("FORMATO"))) {
				response.setContentType("application/json");
				if(Objects.isNull(request.getParameter("ID-DOMINIO"))) {
					List<OpcionDTO> opciones = opcionEjbRemote.listar();
					System.out.println(opciones);
					response.getWriter().print(JSONArray.fromObject(opciones));
				}else {
					//List<Opcion> opciones = opcionesDao.getOpcionesByIdDominio(Integer.parseInt(request.getParameter("ID-DOMINIO")));
					List<OpcionDTO> opciones = opcionEjbRemote.
					//Opcion opc = opcionesDao.getOpcionesByIdDominio(Integer.parseInt(request.getParameter("ID-DOMINIO")));
					response.getWriter().print(JSONArray.fromObject(opciones));
				}
			}
			

		} else {
			request.getSession().setAttribute("DOMINIOS", dominios.listar());
			request.getSession().setAttribute("OPCIONES", opcionesDao.listar());
			request.getRequestDispatcher("abmOpcion.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		OpcionDao opdao = DaoFactory.getOpcionDao();
		Opcion opcion = new Opcion();
		DominioDao dominios = DaoFactory.getDominioDao();
		if ("INSERTAR".equals(request.getParameter("ACCION"))) {
			if (Objects.nonNull(request.getParameter("dominio"))) {
				Dominio dominio = new Dominio(Integer.parseInt(request.getParameter("dominio")));
				opcion.setDominio(dominio);
			}

			if (Objects.nonNull(request.getParameter("codigo"))) {
				opcion.setCodigo(request.getParameter("codigo"));
			}
			if (Objects.nonNull(request.getParameter("descripcion"))) {
				opcion.setDescripcion(request.getParameter("descripcion"));
			}
			if (Objects.nonNull(request.getParameter("estado"))) {
				opcion.setEstado(request.getParameter("estado"));
			}
			if (Objects.nonNull(request.getParameter("padre"))) {
				Opcion oPadre = new Opcion();
				if (!"null".equals(request.getParameter("padre"))) {
					oPadre.setId(Integer.parseInt(request.getParameter("padre")));
					opcion.setPadre(oPadre);
					System.out.println(request.getParameter("padre"));
					System.out.println("padre: " + oPadre);
				} else {
					opcion.setPadre(oPadre);
				}
			}
			System.out.println(opcion.toString());

			try {
				opdao.insertar(opcion);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		if ("EDITAR".equals(request.getParameter("ACCION"))) {
			System.out.println("acccion de editar");
			Opcion op = DaoFactory.getOpcionDao().getById(Integer.parseInt(request.getParameter("ID")));
			request.getSession().setAttribute("OPCION", op);
			request.getSession().setAttribute("DOMINIOS", dominios.listar());
			request.getSession().setAttribute("OPCIONES", opdao.listar());
			request.getRequestDispatcher("abmOpcion.jsp").forward(request, response);

		}
		if ("ACTUALIZAR".equals(request.getParameter("ACCION"))) {
			if (Objects.nonNull(request.getParameter("dominio"))) {
				Dominio dominio = new Dominio(Integer.parseInt(request.getParameter("dominio")));
				opcion.setDominio(dominio);
			}

			if (Objects.nonNull(request.getParameter("codigo"))) {
				opcion.setCodigo(request.getParameter("codigo"));
			}
			if (Objects.nonNull(request.getParameter("descripcion"))) {
				opcion.setDescripcion(request.getParameter("descripcion"));
			}
			if (Objects.nonNull(request.getParameter("estado"))) {
				opcion.setEstado(request.getParameter("estado"));
			}
			if (Objects.nonNull(request.getParameter("padre"))) {
				Opcion oPadre = new Opcion();
				if (!"null".equals(request.getParameter("padre"))) {
					oPadre.setId(Integer.parseInt(request.getParameter("padre")));
					opcion.setPadre(oPadre);
					System.out.println(request.getParameter("padre"));
					System.out.println("padre: " + oPadre);
				} else {
					opcion.setPadre(oPadre);
				}
			}
			System.out.println(opcion.toString());

			try {
				opdao.insertar(opcion);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			response.sendRedirect(request.getContextPath() + "/Opciones-servlet");

		}

	}
}
