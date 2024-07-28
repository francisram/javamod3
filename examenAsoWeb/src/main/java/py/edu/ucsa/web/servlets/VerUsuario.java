package py.edu.ucsa.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class VerUsuario
 */
@WebServlet(urlPatterns = {"/VerUsuario"})
public class VerUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>Usuario</title></head><body>");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		if(session != null) {
			out.print("<h1>nombre del usuario</h1></br>");
			if (session.getAttribute("usuario") != null) {
				String usuario = (String) session.getAttribute("usuario"); 
				out.print("<h2>"+usuario+"</h2>");
			}
			else {
				out.print("<h1>la aplicacion no obtuvo la session</h1>");
			}
			out.print("</body></html>");
		}
	}

}
