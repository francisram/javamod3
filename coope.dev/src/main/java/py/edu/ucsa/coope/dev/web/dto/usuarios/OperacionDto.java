package py.edu.ucsa.coope.dev.web.dto.usuarios;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import py.edu.ucsa.coope.dev.web.dto.BaseDtoWithId;
import py.edu.ucsa.coope.dev.web.dto.MenuDto;
import py.edu.ucsa.coope.dev.web.dto.OpcionDto;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperacionDto extends BaseDtoWithId {

	private static final long serialVersionUID = -664548340898367898L;
	private Long id;
	private OpcionDto accion;
	private OpcionDto estado;
	private MenuDto menu;
	private RolDtoEnum rol;
}