package py.edu.ucsa.coope.dev.web.security.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import py.edu.ucsa.coope.dev.core.entities.Token;



public interface TokenRepository extends JpaRepository<Token, Long> {

  @Query(value = "select t from Token t inner join Usuario u "
  		+ "on t.usuario.id = u.id where u.id = :id and (t.expirado "
  		+ "= false or t.revocado = false)")
  List<Token> findAllValidTokensByUsuario(Long id);

  Optional<Token> findByToken(String token);
}
