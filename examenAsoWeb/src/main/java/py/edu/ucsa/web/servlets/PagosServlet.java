package py.edu.ucsa.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.Objects;

@WebServlet(urlPatterns = {"/PagosServlet"})
/**
 * Servlet implementation class PagosServlet
 */
public class PagosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		/*
		if (Objects.isNull(request.getParameter("ACCION")) || "".equals(request.getParameter("ACCION"))
				|| "LISTAR".equals(request.getParameter("ACCION"))) {
			PagoCuotaSocioDao pagoscuotas = DaoFactory.getPagoCuotaSocioDao();
			if (request.getSession().getAttribute("PAGOS") == null) {
				request.getSession().setAttribute("PAGOS", pagoscuotas.listar());
			}
			request.getRequestDispatcher("pagoscuotas.jsp").forward(request, response);

		} else {
			SocioDao socioDao = DaoFactory.getSocioDao();
			if (request.getSession().getAttribute("SOCIOS") == null) {
				request.getSession().setAttribute("SOCIOS", socioDao.listar());
			}
			request.getRequestDispatcher("pagos.jsp").forward(request, response);
		}
		
		
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
