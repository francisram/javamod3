package py.edu.ucsa.web.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import py.edu.ucsa.ejb.entities.Usuario;
import py.edu.ucsa.ejb.services.UsuarioEjbRemote;


@WebServlet(urlPatterns = { "/Login" })
public class Login extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UsuarioEjbRemote usuarioEjbClient;

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
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				/*
				request.getSession(true).setAttribute("SOCIO_CONECTADO", usuario);
				List<Rol> roles = DaoFactory.getUsuarioDao().getRolesByUsuario(usuario.getId());
				request.getSession().setAttribute("ROLES", roles);
				System.out.println(roles);
				*/
				request.getRequestDispatcher("menu.jsp").forward(request, response);
			}

		}

	}
}
