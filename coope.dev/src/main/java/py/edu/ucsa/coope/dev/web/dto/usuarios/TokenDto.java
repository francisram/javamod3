package py.edu.ucsa.coope.dev.web.dto.usuarios;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import py.edu.ucsa.coope.dev.web.security.TokenType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenDto {
  public Long id;
  public String token;
  @Enumerated(EnumType.STRING)
  public TokenType tipoToken = TokenType.BEARER;
  public boolean revocado;
  public boolean expirado;
  public UsuarioDto usuario;
}