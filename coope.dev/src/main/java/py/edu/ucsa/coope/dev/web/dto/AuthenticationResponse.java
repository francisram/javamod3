package py.edu.ucsa.coope.dev.web.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import py.edu.ucsa.coope.dev.web.dto.usuarios.ItemNavegacionDto;
import py.edu.ucsa.coope.dev.web.dto.usuarios.UsuarioDto;
import py.edu.ucsa.coope.dev.web.security.entities.OperacionesXItemNavegacion;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
	  @JsonProperty("accessToken")
	  private String accessToken;
	  @JsonProperty("user")
	  private UsuarioDto user;
	  @JsonProperty("navigationItems")
	  private List<ItemNavegacionDto> itemsNavegacion;
	  @JsonProperty("grantedOperations")
	  private List<OperacionesXItemNavegacion> operacionesDelUsuario;
	  @JsonProperty("refreshToken")
	  private String refreshToken;
}
