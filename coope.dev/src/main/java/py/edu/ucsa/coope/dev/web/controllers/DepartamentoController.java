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

import py.edu.ucsa.coope.dev.core.services.DepartamentoService;
import py.edu.ucsa.coope.dev.web.dto.CiudadDto;
import py.edu.ucsa.coope.dev.web.dto.DepartamentoDto;
import py.edu.ucsa.coope.dev.web.dto.ErrorDto;
import py.edu.ucsa.coope.dev.web.dto.PaginadoDto;
import py.edu.ucsa.coope.dev.web.validators.impl.ValidadorCiudad;
import py.edu.ucsa.coope.dev.web.validators.impl.ValidadorDepartamento;

@RequestMapping("/departamentos")
@RestController
public class DepartamentoController {
	public static final Logger logger = LoggerFactory.getLogger(DepartamentoController.class);

	@Autowired
	private DepartamentoService deptoService;
	
	@GetMapping
	public ResponseEntity< List<DepartamentoDto>> list(){
		return ResponseEntity.ok(deptoService.listar());
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
		
		PaginadoDto<DepartamentoDto> paginado = deptoService.listar(tamanioPagina, pagina, ordenarPor, orden, busqueda);
		
		return new ResponseEntity<PaginadoDto<DepartamentoDto>>(paginado,HttpStatus.OK);
		
	}
	
	@GetMapping("/{idCiudad}")
	public ResponseEntity<DepartamentoDto> getById(@PathVariable("idCiudad") Integer id){
		return ResponseEntity.ok(deptoService.getById(id));
	}
	
	
	@PostMapping
	public ResponseEntity<?> insertar(@RequestBody DepartamentoDto objeto) {
		objeto.getValidadores().add(new ValidadorDepartamento());
		
		List<ErrorDto> errores = objeto.ejecutarValidadores();
		if(!errores.isEmpty()) {
			return new ResponseEntity<List<ErrorDto>>(errores, HttpStatus.PRECONDITION_FAILED);
		}
		
		return ResponseEntity.ok(deptoService.persistir(objeto));
		
	}
	
	@PutMapping
	public ResponseEntity<?> actualizar(@RequestBody DepartamentoDto objeto) {
		objeto.getValidadores().add(new ValidadorDepartamento());
		//objeto.getValidadores().add(new ValidadorBarrioFecha());
		
		List<ErrorDto> errores = objeto.ejecutarValidadores();
		if(!errores.isEmpty()) {
			return new ResponseEntity<List<ErrorDto>>(errores,HttpStatus.PRECONDITION_FAILED);
		}
		return ResponseEntity.ok(deptoService.actualizar(objeto));
	}
	

	
	@DeleteMapping("/{idDepartamento}")
	public ResponseEntity<?> eliminar(@PathVariable("idCiudad") Integer id) {

	    DepartamentoDto entity = deptoService.getById(id); 
	    if (entity == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ciudad no encontrada.");
	    }
	    deptoService.eliminar(id);
	    return ResponseEntity.ok("Ciudad eliminado correctamente.");
	}
	
	

}
