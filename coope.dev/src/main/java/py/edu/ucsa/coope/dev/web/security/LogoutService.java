package py.edu.ucsa.coope.dev.web.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler {

	private final TokenDao tokenRepository;

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		final String authHeader = request.getHeader("Authorization");
		final String jwt;
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			return;
		}
		jwt = authHeader.substring(7);
		var tokenGuardado = tokenRepository.findByToken(jwt).orElse(null);
		if (tokenGuardado != null) {
			tokenGuardado.setExpirado(true);
			tokenGuardado.setRevocado(true);
			tokenRepository.persistir(tokenGuardado);
			SecurityContextHolder.clearContext();
		}
	}
}
