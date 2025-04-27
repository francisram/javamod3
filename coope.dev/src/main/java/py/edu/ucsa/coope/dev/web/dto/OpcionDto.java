package py.edu.ucsa.coope.dev.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import py.edu.ucsa.coope.dev.web.dto.usuarios.DominioDto;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpcionDto extends BaseDtoWithId {

	private static final long serialVersionUID = 8021401515250121445L;
	private DominioDto dominio;
	private String codigo;
	private String descripcion;
	private String estado;
	private OpcionDto opcionPadre;
	private Boolean porDefecto;
	private String icono;
	private Integer ordenPreferido;
}