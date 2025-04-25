package py.edu.ucsa.coope.dev.web.controllers;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.edu.ucsa.coope.dev.core.services.BarrioService;
import py.edu.ucsa.coope.dev.web.validators.impl.ValidadorBarrio;
import py.edu.ucsa.coope.dev.web.dto.BarrioDto;
import py.edu.ucsa.coope.dev.web.dto.ErrorDto;


@RequestMapping("/barrios")
@RestController
public class BarrioController {

	public static final Logger  logger = LoggerFactory.getLogger(BarrioController.class);
	
	
	@Autowired
	private BarrioService barrioSrv;
	
	
	@GetMapping
	public ResponseEntity< List<BarrioDto>> list(){
		return ResponseEntity.ok(barrioSrv.listar());
	}
	
	/*
	 * @GetMapping public ResponseEntity<?> listar(){
	 * logger.info("obteniendo todas la opciones"); List<BarrioDto> barrios =
	 * barrioSrv.listar(); logger.info("cantidad de opciones devueltas : " +
	 * barrios.size()); return new ResponseEntity<List<Barrio>> (barrios,
	 * HttpStatus.OK); }
	 */
	
	public ResponseEntity<List<BarrioDto>>listar(){
		return ResponseEntity.ok(barrioSrv.listar());
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
		
		PaginadoDto<BarrioDto> paginado = barrioSrv.listar(tamanioPagina, pagina, ordenarPor, orden, busqueda);
		
		return new ResponseEntity<PaginadoDto<BarrioDto>>(paginado,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/{idBarrio}")
	public ResponseEntity<BarrioDto> getById(@PathVariable("idBarrio") Integer id) {
		return ResponseEntity.ok(barrioSrv.getById(id));
	}
	
	@PostMapping
	public ResponseEntity<?> insertar(@RequestBody BarrioDto objeto) {
		objeto.getValidadores().add(new ValidadorBarrio());
		//objeto.getValidadores().add(new ValidadorBarrioFecha());
		
		List<ErrorDto> errores = objeto.ejecutarValidadores();
		if(!errores.isEmpty()) {
			return new ResponseEntity<List<ErrorDto>>(errores,HttpStatus.PRECONDITION_FAILED);
		}
		return ResponseEntity.ok(barrioSrv.persistir(objeto));
	}
	
	@PutMapping
	public ResponseEntity<?> actualizar(@RequestBody BarrioDto objeto) {
		objeto.getValidadores().add(new ValidadorBarrio());
		//objeto.getValidadores().add(new ValidadorBarrioFecha());
		
		List<ErrorDto> errores = objeto.ejecutarValidadores();
		if(!errores.isEmpty()) {
			return new ResponseEntity<List<ErrorDto>>(errores,HttpStatus.PRECONDITION_FAILED);
		}
		return ResponseEntity.ok(barrioSrv.actualizar(objeto));
	}
	
	
	@GetMapping("/by-ciudad/{idCiudad}")
	public ResponseEntity<?> getBarriosByIdCiudad(@PathVariable Integer idCiudad) {
		return ResponseEntity.ok(barrioSrv.getBarriosByIdCiudad(idCiudad));
	}
	
	@DeleteMapping("/{idBarrio}")
	public ResponseEntity<?> eliminar(@PathVariable("idBarrio") Integer id) {

	    BarrioDto entity = barrioSrv.getById(id); 
	    if (entity == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Barrio no encontrado.");
	    }
	    barrioSrv.eliminar(id);
	    return ResponseEntity.ok("Barrio eliminado correctamente.");
	}


	
	

}
