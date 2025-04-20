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
public class ItemNavegacionXPerfilDto extends BaseDtoWithId {

	private static final long serialVersionUID = -8015589261105533148L;
	private OpcionDto estado;
	private PerfilDto perfil;
	private ItemNavegacionDto itemNavegacion;
}