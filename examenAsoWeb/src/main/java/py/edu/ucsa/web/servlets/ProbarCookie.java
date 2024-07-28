package py.edu.ucsa.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ProbarCookie
 */
@WebServlet(urlPatterns = {"/ProbarCookie"})
public class ProbarCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProbarCookie() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	resp.getWriter().append("Server at: ").append(req.getContextPath());
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out  = response.getWriter();
		out.print("<html><head><title>enviar cookies</title></head>");
		out.print("<body><h1>estamos enviado cookies al navegador</h1>");
		Cookie cookie = new Cookie("cookieUsuario", request.getParameter("usuario"));
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
		out.print("</body></html>");
	}

}
