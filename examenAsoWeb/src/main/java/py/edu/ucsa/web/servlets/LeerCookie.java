package py.edu.ucsa.web.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LeerCookie")
public class LeerCookie extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>leer cookies </title></head>");
		out.print("<body>estamos leyendo las cookies enviadas por el navegfador");
		if (request.getCookies() != null && request.getCookies().length > 0) {
			for(Cookie cookie : request.getCookies()) {
				if("cookieUsuario".equals(cookie.getName())) {
					out.print("<h2>nombre de la cookie</h2>"+cookie.getName()+"</h2>");
					out.print("<h2>valor de la cookie</h2>"+cookie.getValue()+"</h2>");
				}
			}
		}
		out.print("</body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
