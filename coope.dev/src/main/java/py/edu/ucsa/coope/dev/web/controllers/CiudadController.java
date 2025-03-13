package py.edu.ucsa.coope.dev.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import py.edu.ucsa.coope.dev.core.services.CiudadServices;
import py.edu.ucsa.coope.dev.web.dto.CiudadDto;

@RequestMapping("/ciudades")
@RestController
public class CiudadController {
	
	@Autowired
	private CiudadServices ciudadService;
	
	@GetMapping
	public ResponseEntity< List<CiudadDto>> list(){
		return ResponseEntity.ok(ciudadService.listar());
	}

}
