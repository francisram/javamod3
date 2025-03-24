package py.edu.ucsa.coope.dev.web.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AutenticationResponse {
	
	@JsonProperty("accessToken")
	private String accesstoken;
	@JsonProperty("user")
	private UsuarioDto user;
	@JsonProperty("navigationItems")
	private List<ItemNavegacionDto> itemsNavegacion;
	@JsonProperty("grantedOperations")
	private List<OperacionXItemNavegacion> operacionesDelUsuario;
	@JsonProperty("refreshToken")
	private String refreshToken;

}
