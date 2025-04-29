package py.edu.ucsa.coope.dev.web.dto;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import py.edu.ucsa.coope.dev.web.dto.usuarios.UsuarioDto;
import py.edu.ucsa.coope.dev.web.validators.Validable;
import py.edu.ucsa.coope.dev.web.validators.Validador;

@Data
public class BarrioDto extends BaseDto implements Validable<BarrioDto> {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombre;
	private CiudadDto ciudad;
	private UsuarioDto usuarioAlta;
	private UsuarioDto usuarioModificacion;
	
	@JsonIgnore
	List<Validador<BarrioDto>> validadores;
	
	@Override
	public List<ErrorDto> ejecutarValidadores() {
		List<ErrorDto> errores = new ArrayList<>();
		this.getValidadores().forEach(v -> errores.addAll(v.validar(this)));
		return errores;
	}
	
	@Override
	public void agregarValidador(Validador<BarrioDto> v) {
		this.getValidadores().add(v);
	}

	public List<Validador<BarrioDto>> getValidadores(){
		if(Objects.isNull(validadores)) {
			validadores = new ArrayList<>();
		}
		return validadores;
	}
	
	
}
