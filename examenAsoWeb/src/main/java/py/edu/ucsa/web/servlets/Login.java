package py.edu.ucsa.web.servlets;

import java.io.IOException;
import java.util.Objects;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import py.edu.ucsa.ejb.entities.RolUsuario;
import py.edu.ucsa.ejb.entities.Usuario;
import py.edu.ucsa.ejb.services.RolUsuarioEjbRemote;
import py.edu.ucsa.ejb.services.UsuarioEjbRemote;


@WebServlet(urlPatterns = { "/Login" })
public class Login extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB(mappedName = "java:global/AsoWebJPA-0.0.1/UsuarioEjbImpl!py.edu.ucsa.ejb.services.UsuarioEjbRemote")
	private UsuarioEjbRemote usuarioEjbClient;
	
	@EJB(mappedName = "java:global/AsoWeb-0.0.1/RolUsuarioEjbImpl!py.edu.ucsa.ejb.services.RolUsuarioEjbRemote")
	private RolUsuarioEjbRemote rolUsuarioEjbRemote;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Aquí puedes manejar la lógica de autenticación
		String username = null;
		String password = null;

		if (!Objects.nonNull(request.getParameter("usuario")) || !Objects.nonNull(request.getParameter("password"))) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {

			username = request.getParameter("usuario");
			password = request.getParameter("password");

			Usuario usuario = usuarioEjbClient.validarUsuario(username, password);

			if (Objects.isNull(usuario)) {
				System.out.println("Inicio de sesión fallido: usuario--> " + username + " pass--> " + password);
				System.out.println("fallo de inicio de session");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				System.out.println("usuario conectado " + usuario);
				request.getSession(true).setAttribute("SOCIO_CONECTADO :", usuario);
				HttpSession session = request.getSession(true); 
				session.setAttribute("SOCIO_CONECTADO", usuario);
				//List<RolUsuario> roles = DaoFactory.getUsuarioDao().getRolesByUsuario(usuario.getId());
				Iterable<RolUsuario> roles = rolUsuarioEjbRemote.getRolesByUsuario(usuario);
				request.getSession().setAttribute("ROLES", roles);
				request.getRequestDispatcher("menu.jsp").forward(request, response);
			}

		}

	}
}
