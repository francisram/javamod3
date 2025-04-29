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
public class DepartamentoDto extends BaseDto implements Validable<DepartamentoDto> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombre;
	private UsuarioDto usuarioAlta;
	private UsuarioDto usuarioModificacion;
	
	@JsonIgnore
	List<Validador<DepartamentoDto>> validadores;
	
	
	@Override
	public List<ErrorDto> ejecutarValidadores() {
		List<ErrorDto> errores = new ArrayList<>();
		return errores;
	}
	@Override
	public void agregarValidador(Validador<DepartamentoDto> v) {
		// TODO Auto-generated method stub
		this.getValidadores().add(v);
	}
	
	public List<Validador<DepartamentoDto>> getValidadores(){
		if(Objects.isNull(validadores)) {
			validadores = new ArrayList<>();
		}
		return validadores;
	}

}
