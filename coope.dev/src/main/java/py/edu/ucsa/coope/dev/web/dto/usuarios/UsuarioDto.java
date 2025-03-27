package py.edu.ucsa.coope.dev.web.dto.usuarios;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class UsuarioDto extends BaseDtoWithId {

	private static final long serialVersionUID = 4109191035176886752L;
	private String nombres;
	private String apellidos;
	private String usuario;
	private String email;
	private String password;
	private String avatar;
	private String status; //en linea, ocupado, ausente
	private OpcionDto estado;
	@Enumerated(EnumType.STRING)
	private RolDtoEnum rol;
	@JsonIgnore
	private List<TokenDto> tokens;
	private List<ItemNavegacionDto> navigationItems;
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return rol.getAuthorities();
//	}
}
