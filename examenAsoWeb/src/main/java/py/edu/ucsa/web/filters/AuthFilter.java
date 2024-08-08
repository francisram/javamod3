package py.edu.ucsa.web.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/*" })
public class AuthFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;
	
	

	public AuthFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);

		boolean isLoggedIn = (session != null && session.getAttribute("SOCIO_CONECTADO") != null);
			System.out.println("status de logueo: "+ isLoggedIn);
		String loginURI = httpRequest.getContextPath() + "/Login";

		boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);

		boolean isLoginPage = httpRequest.getRequestURI().endsWith("login.jsp");

		if (isLoggedIn && (isLoginRequest || isLoginPage)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/");
			dispatcher.forward(request, response);

		} else if (isLoggedIn || isLoginRequest) {
			chain.doFilter(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);

		}
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	
	}



}
