package py.edu.ucsa.coope.dev.web.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import py.edu.ucsa.coope.dev.web.dto.usuarios.PerfilXUsuarioDto;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistroRequest {

	private String nombres;
	private String apellidos;
	private String email;
	private String usuario;
	private String password;
	
	private List<PerfilXUsuarioDto> perfiles;
	
}
