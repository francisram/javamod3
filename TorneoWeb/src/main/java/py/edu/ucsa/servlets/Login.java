package py.edu.ucsa.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		// Aquí puedes manejar la lógica de autenticación
		String username = null;
		String password = null;

		if (!Objects.nonNull(request.getParameter("usuario")) || !Objects.nonNull(request.getParameter("password"))) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {

			username = request.getParameter("usuario");
			password = request.getParameter("password");

			Usuario usuario = DaoFactory.getUsuarioDao().validarUsuario(username, password);

			if (Objects.isNull(usuario)) {
				System.out.println("Inicio de sesión fallido: usuario--> " + username + " pass--> " + password);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				request.getSession(true).setAttribute("SOCIO_CONECTADO", usuario);
				List<Rol> roles = DaoFactory.getUsuarioDao().getRolesByUsuario(usuario.getId());
				request.getSession().setAttribute("ROLES", roles);
				System.out.println(roles);
				request.getRequestDispatcher("menu.jsp").forward(request, response);
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
