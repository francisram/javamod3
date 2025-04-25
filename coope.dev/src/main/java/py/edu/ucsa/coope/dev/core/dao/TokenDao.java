package py.edu.ucsa.coope.dev.core.dao;

import java.util.List;
import java.util.Optional;

import py.edu.ucsa.coope.dev.web.security.entities.Token;


public interface TokenDao extends GenericDao<Integer, Token> {

	List<Token> findAllValidTokensByUsuario(Integer id);
	Optional<Token> findByToken(String token);
	
}
