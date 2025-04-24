package py.edu.ucsa.coope.dev.web.controllers;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import py.edu.ucsa.coope.dev.web.dto.AuthenticationRequest;
import py.edu.ucsa.coope.dev.web.dto.AuthenticationResponse;
import py.edu.ucsa.coope.dev.web.dto.RegistroRequest;
import py.edu.ucsa.coope.dev.web.security.AuthenticationService;


@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationService service;

	@PostMapping("/registrar")
	public ResponseEntity<AuthenticationResponse> register (@RequestBody RegistroRequest request)
	{
		return ResponseEntity.ok(service.registrar(request));
	
	}

	@PostMapping("/autenticar")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request)
	{
		return ResponseEntity.ok(service.autenticar(request));
		//return null;
	}

	@PostMapping("/refrescar-token")
	public void refreshToken(HttpServletRequest request , HttpServletResponse response) throws IOException
	{
		
		service.refreshToken(request, response);
	}

}
