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
public class OperacionesXItemNavegacionDto extends BaseDtoWithId{

	private static final long serialVersionUID = 2493399837410762506L;
	
	private OpcionDto estado;
	private OpcionDto accion;
	private ItemNavegacionDto itemNavegacion;

}