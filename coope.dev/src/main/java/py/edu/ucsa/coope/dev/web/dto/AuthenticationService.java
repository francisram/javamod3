package py.edu.ucsa.coope.dev.web.dto;

import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import py.edu.ucsa.coope.dev.web.dto.usuarios.ItemNavegacionDto;
import py.edu.ucsa.coope.dev.web.dto.usuarios.PerfilXUsuarioDto;
import py.edu.ucsa.coope.dev.web.dto.usuarios.UsuarioDto;
import py.edu.ucsa.coope.dev.web.security.JwtService;
import py.edu.ucsa.coope.dev.web.security.Token;
import py.edu.ucsa.coope.dev.web.security.TokenType;
import py.edu.ucsa.coope.dev.web.security.entities.ItemNavegacion;
import py.edu.ucsa.coope.dev.web.security.entities.Usuario;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	
	private final UsuarioRepo usuarioRepo;
	private final ItemNavegacionRepo itemNavRepo;
	private final TokenRepository tokenRepo;
	private final PasswordEncoder passwordEnconder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	
	public AuthenticationResponse registrar(RegistroRequest request) {
		var user = Usuario.builder().nombres(request.getNombres()).apellidos(request.getApellidos())
				.email(request.getEmail()).usuario(request.getUsuario())
				.password(request.getPassword())).build();
	var usuGuardado = usuarioRepo.save(user);
	var jwtToken = jwtService.generarToken(user);
	var refreshToken = jwtService.generarRefreshToken(user);
	grabarTokenDeUsuario(usuGuardado , jwtToken);
	return AuthenticationResponse.builder().accessToken(jwtToken).refreshToken(refreshToken).build();
	}


	public AuthenticationResponse autenticar(AuthenticationRequest request) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsuario() , request.getPassword()));
		var usu = usuarioRepo.findByUsuario(request.getUsuario()).orElseThrow();
		
		List<ItemNavegacion> itemsNav = itemNavRepo.findNavByIdUsuario(request.getUsuario()).orElseThrow();
		List<ItemNavegacionDto> result =  itemNavegacionMapper.mapToDtoList(itemsNav);
		List<OperacionXItemNavegacion> operXItemNav = itemNavRepo.findOperacionXItemNavByIdUsuario(usu.getId()).orElseThrow();
		var jwtToken = jwtService.generarToken(usu);
		var refreshToken = jwtService.generarRefreshToken(usu);
		
		revocarTodosLosTokensDelUsuario(usu);
		grabarTokenDeUsuario(usu , jwtToken);
		
		UsuarioDto usuDto =  usu.toDto();
		usuDto.setNavigationItems(result);
		
		return AuthenticationResponse.builder().accessToken(jwtToken).refreshTokenre(refreshToken)
				.user(usuDto).operacionesDelUsuario(operXItemNav).build();
		
	}
	
	private List<PerfilXUsuarioDto> getPerfilesFromDtoList(List<PerfilXUsuarioDto> dtosPerfiles){
		List<PerfilXUsuarioDto> perfiles =  dtosPerfiles.
				stream().
				map(p -> PerfilXUsuarioDto.fromDto(perfil))
				.collect(Collectors.toList()));
		return perfiles;
		
	}
	
	private void grabarTokenDeUsuario(Usuario user, String jwtToken) {
		// TODO Auto-generated method stub
		 var token = Token.builder().usuario(user).token(jwtToken)
				 .tipoToken(TokenType.BEARER).expirado(false).revocado(false)
				 .build();
		 tokenRepo.save(token);
		
	}
	

	private void revocarTodosLosTokensDelUsuario(Usuario usu) {
		// TODO Auto-generated method stub
		
		var validUserTokens =  tokenRepo.findAllValidTokenByUsuario(usu.getId());
		if(validUserTokens.isEmpty()) {
			return;
		}
		validUserTokens.foreach(token ->{
				token.setExpirado(true);
				token.setRevocado(true);}
				);
		tokenRepo.saveAll(validUserTokens);
		
	}
	
	public void refreshToken(HttpServletRequest request , HttpServletResponse response) throws IOException {
		final String authHeader = request.getHeader(org.springframework.http.HttpHeaders.AUTHORIZATION);
		final String refreshToken;
		final String userEmail;
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			return;
		}
		
		refreshToken = authHeader.substring(7);
		userEmail = jwtService.extractUserName(refreshToken);
		if(userEmail != null) {
			var user =  this.usuarioRepo.findByUsuario(userEmail).orElseThrow();
			if(jwtService.isTokenValid(refreshToken, user)) {
				var accessToken = jwtService.generarToken(user);
				revocarTodosLosTokensDelUsuario(user);
				grabarTokenDeUsuario(user, accessToken);
				var authResponse = AuthenticationResponse.builder().accessToken(accessToken)
						.refreshToken(refreshToken).build();
				new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
				
			}
		}
	}

}
