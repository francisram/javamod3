package py.edu.ucsa.coope.dev.web.validators.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import py.edu.ucsa.coope.dev.web.dto.CiudadDto;
import py.edu.ucsa.coope.dev.web.dto.DepartamentoDto;
import py.edu.ucsa.coope.dev.web.dto.ErrorDto;
import py.edu.ucsa.coope.dev.web.validators.Validador;

public class ValidadorDepartamento implements Validador<DepartamentoDto> {

	@Override
	public List<ErrorDto> validar(DepartamentoDto obj) {
		List<ErrorDto> errores =  new ArrayList<>();
		/*
		if(Objects.isNull(obj.getDepartamento())) {
			errores.add(new ErrorDto("EL DEPARTAMENTO ES REQUERIDO PARA REGISTRAR LA CIUDAD"));
		}
		*/
		if(Objects.isNull(obj.getNombre()) || obj.getNombre().isBlank()) {
			errores.add(new ErrorDto("EL NOMBRE DEL DEPATAMENTO ES REQUERIDO PARA REGISTRAR"));
		}
		if(Objects.isNull(obj.getUsuarioAlta()) || Objects.isNull(obj.getUsuarioAlta().getId())) {
			errores.add(new ErrorDto("EL ID DE USUARIO ALTA ES REQUERIDO PARA REGISTRAR EL DEPARTAMENTO"));
		}
		
		if (errores.isEmpty()) {
			if(Objects.nonNull(obj.getNombre())) {
				obj.setNombre(obj.getNombre().toUpperCase());
			}
		}
		
		return errores;
	}

}
