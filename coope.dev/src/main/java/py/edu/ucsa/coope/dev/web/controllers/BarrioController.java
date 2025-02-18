package py.edu.ucsa.coope.dev.web.controllers;



import java.util.List;

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

import py.edu.ucsa.coope.dev.core.entities.Barrio;
import py.edu.ucsa.coope.dev.core.services.BarrioServices;
import py.edu.ucsa.coope.dev.web.dto.BarrioDto;



@RequestMapping("/barrios")
@RestController
public class BarrioController {
	public static final Logger  logger = LoggerFactory.getLogger(BarrioController.class);
	
	
	@Autowired
	private BarrioServices barrioSrv;
	
	/*
	@GetMapping
	public ResponseEntity< List<Barrio>> list(){
		return ResponseEntity.ok(barrioSrv.listar());
	}
	*/
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
	
	
	@GetMapping("/{idBarrio}")
	public ResponseEntity<BarrioDto> getById(@PathVariable("idBarrio") Integer id) {
		return ResponseEntity.ok(barrioSrv.getById(id));
	}
	
	@PostMapping
	public ResponseEntity<?> insertar(@RequestBody BarrioDto objeto) {
		return ResponseEntity.ok(barrioSrv.persistir(objeto));
	}
	@PutMapping
	public ResponseEntity<?> actualizar(@RequestBody BarrioDto objeto) {
		return ResponseEntity.ok(barrioSrv.actualizar(objeto));
	}
	
	
	@GetMapping("/by-ciudad/{idCiudad}")
	public ResponseEntity<?> getBarriosByIdCiudad(@PathVariable Integer idCiudad) {
		return ResponseEntity.ok(barrioSrv.getBarriosByIdCiudad(idCiudad));
	}
	
	
	

}
