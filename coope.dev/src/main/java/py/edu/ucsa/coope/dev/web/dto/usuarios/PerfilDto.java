package py.edu.ucsa.coope.dev.web.dto.usuarios;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import py.edu.ucsa.coope.dev.web.dto.BaseDtoWithId;
import py.edu.ucsa.coope.dev.web.dto.OpcionDto;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class PerfilDto extends BaseDtoWithId {

	private static final long serialVersionUID = -5336844840141880363L;

	private OpcionDto estado;
	private String codigo;
	private String nombre;
	private String descripcion;
}
