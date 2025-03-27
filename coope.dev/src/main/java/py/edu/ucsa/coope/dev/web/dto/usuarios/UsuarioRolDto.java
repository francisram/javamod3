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
public class UsuarioRolDto extends BaseDtoWithId{

	private static final long serialVersionUID = 801356735259572683L;
	private OpcionDto estado;
	private RolDto rol;
	private UsuarioDto usuario;
}