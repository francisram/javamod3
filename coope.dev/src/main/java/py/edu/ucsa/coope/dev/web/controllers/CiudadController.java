package py.edu.ucsa.coope.dev.web.controllers;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import py.edu.ucsa.coope.dev.core.services.CiudadService;
import py.edu.ucsa.coope.dev.web.dto.CiudadDto;
import py.edu.ucsa.coope.dev.web.dto.ErrorDto;
import py.edu.ucsa.coope.dev.web.dto.PaginadoDto;
import py.edu.ucsa.coope.dev.web.validators.impl.ValidadorCiudad;


@RequestMapping("/ciudades")
@RestController
public class CiudadController {
	
	public static final Logger logger = LoggerFactory.getLogger(CiudadController.class);
	
	@Autowired
	private CiudadService ciudadService;
	
	@GetMapping
	public ResponseEntity< List<CiudadDto>> list(){
		return ResponseEntity.ok(ciudadService.listar());
	}
	
	@GetMapping("/paginado")
	public ResponseEntity<?> finPerPage(
			@RequestParam("page") int pagina,
			@RequestParam("size") int tamanioPagina,
			@RequestParam("sort") String ordenarPor,
			@RequestParam("order") String orden,
			@RequestParam("search") String busqueda	
			){
		if(Objects.nonNull(busqueda)) {
			busqueda = busqueda.toUpperCase();
		}
		logger.info("obteniendo los registros de la pagina {} de un tamaño de {} ordenado por {} en orden {} con la busqueda {} ",pagina,tamanioPagina,ordenarPor,orden,busqueda);
		
		PaginadoDto<CiudadDto> paginado = ciudadService.listar(tamanioPagina, pagina, ordenarPor, orden, busqueda);
		
		return new ResponseEntity<PaginadoDto<CiudadDto>>(paginado,HttpStatus.OK);
		
	}
	
	@GetMapping("/{idCiudad}")
	public ResponseEntity<CiudadDto> getById(@PathVariable("idCiudad") Integer id){
		return ResponseEntity.ok(ciudadService.getById(id));
	}
	
	@PostMapping
	public ResponseEntity<?> insertar(@RequestBody CiudadDto objeto) {
		objeto.getValidadores().add(new ValidadorCiudad());
		
		List<ErrorDto> errores = objeto.ejecutarValidadores();
		if(!errores.isEmpty()) {
			return new ResponseEntity<List<ErrorDto>>(errores, HttpStatus.PRECONDITION_FAILED);
		}
		
		return ResponseEntity.ok(ciudadService.persistir(objeto));
		
	}
	
	@PutMapping
	public ResponseEntity<?> actualizar(@RequestBody CiudadDto objeto) {
		objeto.getValidadores().add(new ValidadorCiudad());
		//objeto.getValidadores().add(new ValidadorBarrioFecha());
		
		List<ErrorDto> errores = objeto.ejecutarValidadores();
		if(!errores.isEmpty()) {
			return new ResponseEntity<List<ErrorDto>>(errores,HttpStatus.PRECONDITION_FAILED);
		}
		return ResponseEntity.ok(ciudadService.actualizar(objeto));
	}
	
	@GetMapping("/by-departamento/{idDepartamento}")
	public ResponseEntity<?> getCiudadesByDepartamento(@PathVariable Integer idDepartamento) {
		return ResponseEntity.ok(ciudadService.getCiudadesByDepartamento(idDepartamento));
	}
	
	@DeleteMapping("/{idCiudad}")
	public ResponseEntity<?> eliminar(@PathVariable("idCiudad") Integer id) {

	    CiudadDto entity = ciudadService.getById(id); 
	    if (entity == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ciudad no encontrada.");
	    }
	    ciudadService.eliminar(id);
	    return ResponseEntity.ok("Ciudad eliminado correctamente.");
	}

}
