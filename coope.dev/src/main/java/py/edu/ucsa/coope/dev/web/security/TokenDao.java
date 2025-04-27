package py.edu.ucsa.coope.dev.web.security;

import java.util.List;
import java.util.Optional;

import py.edu.ucsa.coope.dev.core.dao.GenericDao;
import py.edu.ucsa.coope.dev.web.security.entities.Token;

public interface TokenDao extends GenericDao<Integer, Token> {
List<Token> findValidTokenByUsuario(Integer id);
Optional<Token> findByToken(String token);
}
