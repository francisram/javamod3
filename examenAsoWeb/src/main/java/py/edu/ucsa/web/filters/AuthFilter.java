package py.edu.ucsa.web.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AuthFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);

		boolean isLoggedIn = (session != null && session.getAttribute("SOCIO_CONECTADO") != null);

		String loginURI = httpRequest.getContextPath() + "/Login";

		boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);

		boolean isLoginPage = httpRequest.getRequestURI().endsWith("login.jsp");

		if (isLoggedIn && (isLoginRequest || isLoginPage)) {
			// the admin is already logged in and he's trying to login again
			// then forwards to the admin's homepage
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/");
			dispatcher.forward(request, response);

		} else if (isLoggedIn || isLoginRequest) {
			// continues the filter chain
			// allows the request to reach the destination
			chain.doFilter(request, response);

		} else {
			// the admin is not logged in, so authentication is required
			// forwards to the Login page
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);

		}
	}

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		super.doFilter(req, res, chain);
	}

}
