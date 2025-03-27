package py.edu.ucsa.coope.dev.web.security;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import py.edu.ucsa.coope.dev.web.security.entities.Usuario;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="usu_token", schema="usuarios")
@NamedQuery(name="Token.getTokenActivoPorUsuario",
			query="select t from Token t inner join Usuario u "
					+ "on t.usuario.id = u.id where u.id = :id and (t.expirado "
					+ "= false or t.revocado= false)")
@SequenceGenerator(name = "Token.TokenSeqGenerator", schema = "usuarios", sequenceName = "usu_token_id_seq", allocationSize = 1)
public class Token {
  @Id
	@GeneratedValue(generator = "Token.TokenSeqGenerator",
		  strategy = GenerationType.SEQUENCE)
  public Integer id;

  @Column(unique = true)
  public String token;

  @Enumerated(EnumType.STRING)
  @Builder.Default
  @Column(name = "tipo_token")
  public TokenType tipoToken = TokenType.BEARER;

  public boolean revocado;

  public boolean expirado;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_usuario")
  public Usuario usuario;
}
