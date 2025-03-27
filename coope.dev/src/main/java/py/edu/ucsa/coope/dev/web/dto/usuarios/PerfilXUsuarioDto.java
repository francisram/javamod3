package py.edu.ucsa.coope.dev.web.dto.usuarios;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import py.edu.ucsa.coope.dev.web.dto.BaseDtoWithId;
import py.edu.ucsa.coope.dev.web.dto.OpcionDto;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class PerfilXUsuarioDto extends BaseDtoWithId {

	private static final long serialVersionUID = -4031776921427342879L;	
	
	private OpcionDto estado;
	private PerfilDto perfil;
	private UsuarioDto usuario;

}