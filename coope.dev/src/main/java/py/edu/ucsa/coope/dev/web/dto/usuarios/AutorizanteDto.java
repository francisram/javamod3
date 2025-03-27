package py.edu.ucsa.coope.dev.web.dto.usuarios;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import py.edu.ucsa.coope.dev.web.dto.BaseDtoWithId;
import py.edu.ucsa.coope.dev.web.dto.OpcionDto;

/**
 * The persistent class for the autorizantes database table.
 * 
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class AutorizanteDto extends BaseDtoWithId {

	private static final long serialVersionUID = 1406782670204785016L;

	private OpcionDto estado;

	private OpcionDto nivelAutorizante;

	private UsuarioDto usuarioAutorizante;

	private String observacion;

}