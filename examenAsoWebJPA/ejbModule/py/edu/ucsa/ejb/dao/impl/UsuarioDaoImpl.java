package py.edu.ucsa.ejb.dao.impl;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.NoResultException;
import py.edu.ucsa.ejb.dao.IUsuarioDao;
import py.edu.ucsa.ejb.entities.Rol;
import py.edu.ucsa.ejb.entities.Usuario;


@RequestScoped
@Named("usuarioDAO")
public class UsuarioDaoImpl extends AbstractDao<Long, Usuario> implements IUsuarioDao {

	public UsuarioDaoImpl() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Iterable<Rol> getRolesByUsuario(Integer idUsuario) {
	
			 return this.entityManager.createQuery("SELECT r FROM RolUsuarioDTO r WHERE r.idUsuario = :idUsuario").setParameter(1, idUsuario).getResultList();
			
	}

	@Override
	public Usuario validarUsuario(String username, String password) {
		// TODO Auto-generated method stub
		//return null;
		// this.entityManager.createQuery("SELECT t FROM TorneoDTO t WHERE t.anho = :anho").setParameter("anho", anho).getResultList();
		
		try {
	        Usuario usuario = this.entityManager.createQuery(
	                "SELECT u FROM UsuarioDTO u WHERE u.usuario = :usuario AND u.password = :password", Usuario.class)
	                .setParameter("usuario", username)
	                .setParameter("password", password)
	                .getSingleResult();

	        return usuario;
	    } catch (NoResultException e) {
	        return new Usuario();
	    }
	}

	

}
