package py.edu.ucsa.coope.dev.core.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import py.edu.ucsa.coope.dev.core.dao.AbstractDao;
import py.edu.ucsa.coope.dev.web.security.TokenDao;
import py.edu.ucsa.coope.dev.web.security.entities.Token;

@Repository
public class TokenDaoImpl extends AbstractDao<Integer, Token> implements TokenDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Token> findValidTokenByUsuario(Integer idUsuario) {
		return this.getEntityManager().createQuery("select t from Token t inner join Usuario u "
				+ "on t.usuario.id = u.id where u.id = :idusuario and ( t.expirado = false or t.revocado = false)").setParameter("idUsuario", idUsuario).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Optional<Token> findByToken(String token) {
		//return (Optional<Token>) this.getEntityManager().createQuery("SELECT t FROM  Token t WHERE t.token = :token ").setParameter("token", token).getSingleResult();
		Token result =  this.getEntityManager().createQuery("SELECT t FROM  Token t WHERE t.token = :token ",Token.class).setParameter("token", token).getSingleResult();
		return Optional.ofNullable(result);
	}

}
