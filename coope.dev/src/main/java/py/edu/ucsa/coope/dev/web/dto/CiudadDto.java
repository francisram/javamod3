package py.edu.ucsa.coope.dev.web.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import py.edu.ucsa.coope.dev.web.dto.usuarios.UsuarioDto;
import py.edu.ucsa.coope.dev.web.validators.Validable;
import py.edu.ucsa.coope.dev.web.validators.Validador;

@Data
public class CiudadDto extends BaseDto implements Validable<CiudadDto>  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombre;
	private DepartamentoDto departamento;
	private UsuarioDto usuarioAlta;
	private UsuarioDto usuarioModificacion;
	
	
	@JsonIgnore
	List<Validador<CiudadDto>> validadores;
	
	@Override
	public List<ErrorDto> ejecutarValidadores() {
		List<ErrorDto> errores = new ArrayList<>();
		return errores;
	}
	@Override
	public void agregarValidador(Validador<CiudadDto> v) {
		this.getValidadores().add(v);
		
	}

	public List<Validador<CiudadDto>> getValidadores(){
		if(Objects.isNull(validadores)) {
			validadores = new ArrayList<>();
		}
		return validadores;
	}
	
	
}