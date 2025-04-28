package py.edu.ucsa.coope.dev.web.security;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import py.edu.ucsa.coope.dev.web.dto.AuthenticationRequest;
import py.edu.ucsa.coope.dev.web.dto.AuthenticationResponse;
import py.edu.ucsa.coope.dev.web.dto.RegistroRequest;
import py.edu.ucsa.coope.dev.web.dto.usuarios.ItemNavegacionDto;
import py.edu.ucsa.coope.dev.web.dto.usuarios.OperacionesXItemNavegacionDto;
import py.edu.ucsa.coope.dev.web.dto.usuarios.PerfilXUsuarioDto;
import py.edu.ucsa.coope.dev.web.dto.usuarios.UsuarioDto;
import py.edu.ucsa.coope.dev.web.security.entities.ItemNavegacion;
import py.edu.ucsa.coope.dev.web.security.entities.OperacionesXItemNavegacion;
import py.edu.ucsa.coope.dev.web.security.entities.PerfilXUsuario;
import py.edu.ucsa.coope.dev.web.security.entities.Token;
import py.edu.ucsa.coope.dev.web.security.entities.Usuario;
import py.edu.ucsa.coope.dev.web.security.repo.ItemNavegacionRepo;
import py.edu.ucsa.coope.dev.web.security.repo.TokenRepository;
import py.edu.ucsa.coope.dev.web.security.repo.UsuarioRepo;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
	
	private final UsuarioRepo usuRepo;
	private final ItemNavegacionRepo itemNavRepo;
	private final TokenRepository tokenRepo;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager; 

	public AuthenticationResponse registrar(RegistroRequest request) {
		var user = Usuario.builder().nombres(request.getNombres()).apellidos(request.getApellidos())
				.email(request.getEmail()).usuario(request.getUsuario())
				.password(passwordEncoder.encode(request.getPassword())).build();
		var usuGuardado = usuRepo.save(user);
		var jwtToken = jwtService.generarToken(user);
		var refreshToken = jwtService.generarRefreshToken(user);
		grabarTokenDeUsuario(usuGuardado, jwtToken);
		return AuthenticationResponse.builder().accessToken(jwtToken).refreshToken(refreshToken).build();
	}
	
	public AuthenticationResponse autenticar(AuthenticationRequest request) {
		authenticationManager
		.authenticate(new UsernamePasswordAuthenticationToken(request.getUsuario(), request.getPassword()));
		
		var usu = usuRepo.findByUsuario(request.getUsuario()).orElseThrow();
		
		List<ItemNavegacion> itemsNav = itemNavRepo.findItemsNavByIdUsuario(usu.getId()).orElseThrow();
		List<ItemNavegacionDto> result = ItemNavegacionMapper.mapToDtoList(itemsNav);
		List<OperacionesXItemNavegacion> operXItemNav = itemNavRepo.findOperacionesXItemNavByIdUsuario(usu.getId()).orElseThrow();
		List<OperacionesXItemNavegacionDto> resultOpCItem = OperacionesXItemNavegacionMapper.mapToDtoList(operXItemNav);
		
		var jwtToken = jwtService.generarToken(usu);
		var refreshToken = jwtService.generarRefreshToken(usu);
		
		revocarTodosLosTokensDelUsuario(usu);
		grabarTokenDeUsuario(usu, jwtToken);
		
		UsuarioDto usuDto = usu.toDto();
		usuDto.setNavigationItems(result);
		return AuthenticationResponse.builder().accessToken(jwtToken).refreshToken(refreshToken)
				.user(usuDto).operacionesDelUsuario(resultOpCItem).build();

	}
	
	private List<PerfilXUsuario> getPerfilesFromDtoList(List<PerfilXUsuarioDto> dtosPerfiles) {

		List<PerfilXUsuario> perfiles = dtosPerfiles.stream().map(perfil -> PerfilXUsuario.fromDto(perfil))
				.collect(Collectors.toList());
		return perfiles;
	}
	
	private void grabarTokenDeUsuario(Usuario user, String jwtToken) {
		var token = Token.builder().usuario(user).token(jwtToken)
				.tipoToken(TokenType.BEARER).expirado(false).revocado(false)
				.build();
		tokenRepo.save(token);
	}
	
	private void revocarTodosLosTokensDelUsuario(Usuario usu) {
		var validUserTokens = tokenRepo.findAllValidTokensByUsuario(usu.getId());
		if(validUserTokens.isEmpty()){
			return;
		}
		validUserTokens.forEach(token -> {
			token.setExpirado(true);
			token.setRevocado(true);
		});
		tokenRepo.saveAll(validUserTokens);
	}
	
	public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
		final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		final String refreshToken;
		final String userEmail;
		if(authHeader == null || !authHeader.startsWith("Bearer ")) {
			return;
		}
		
		refreshToken = authHeader.substring(7);
		userEmail = jwtService.extractUsername(refreshToken);
		if(userEmail!=null) {
			var user = this.usuRepo.findByUsuario(userEmail).orElseThrow();
			if(jwtService.isTokenValid(refreshToken, user)) {
				var accessToken = jwtService.generarToken(user);
				revocarTodosLosTokensDelUsuario(user);
				grabarTokenDeUsuario(user, accessToken);
				var authResponse = AuthenticationResponse.builder().accessToken(accessToken).refreshToken(refreshToken)
						.build();
				new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
			}
		}
		
	}
	
}
