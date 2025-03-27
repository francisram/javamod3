package py.edu.ucsa.coope.dev.web.dto.usuarios;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import py.edu.ucsa.coope.dev.web.dto.BaseDtoWithId;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DominioDto extends BaseDtoWithId {

	private static final long serialVersionUID = 4683428432531340269L;

	private String codigo;
	private String descripcion;
	private String estado;
	private DominioDto dominioPadre;
	
}