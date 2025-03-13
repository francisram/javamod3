package py.edu.ucsa.coope.dev.web.validators.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import py.edu.ucsa.coope.dev.web.dto.BarrioDto;
import py.edu.ucsa.coope.dev.web.dto.ErrorDto;
import py.edu.ucsa.coope.dev.web.validators.Validador;

/**
 * clase que realiza las alidaciones basicas sobre un barrio que es enviado para su registro (insercion/modificacion)
 * @author frlopez
 * @version 1.0
 */
public class ValidadorBarrio implements Validador<BarrioDto>{

	@Override
	public List<ErrorDto> validar(BarrioDto obj) {
		
		List<ErrorDto> errores =  new ArrayList<>();
		if(Objects.isNull(obj.getCiudad())) {
			errores.add(new ErrorDto("LA CIUDAD ES REQUERIDA PARA REGISTRAR EL BARRIO"));
		}
		if(Objects.isNull(obj.getNombre()) || obj.getNombre().isBlank()) {
			errores.add(new ErrorDto("EL NOMBRE DEL BARRIO ES REQUERIDO PARA REGISTRAR EL BARRIO"));
		}
		if(Objects.isNull(obj.getUsuarioAlta()) || Objects.isNull(obj.getUsuarioAlta().getId())) {
			errores.add(new ErrorDto("EL ID DE USUARIO ALTA ES REQUERIDO PARA REGISTRAR EL BARRIO"));
		}
		
		if (errores.isEmpty()) {
			if(Objects.nonNull(obj.getNombre())) {
				obj.setNombre(obj.getNombre().toUpperCase());
			}
		}
		
		
		return errores;
	}

}
