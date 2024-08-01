package py.edu.ucsa.ejb.dao.impl;

import java.util.List;
import java.util.Objects;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.TypedQuery;
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

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Rol> getRolesByUsuario(Integer idUsuario) {
	
			 return this.entityManager.createQuery("SELECT r FROM RolUsuarioDTO r WHERE r.idUsuario = :idUsuario").setParameter(1, idUsuario).getResultList();
			
	}

	@Override
	public Usuario validarUsuario(String username, String password) {
	
		
	//	try {
	        TypedQuery<Usuario> q = this.entityManager.createNamedQuery("Usuario.validarUsuario", Usuario.class);
	        q.setParameter("usuario", username);
	        q.setParameter("clave", password);
	        
	        Usuario usuario = q.getSingleResult();

	        if (!Objects.isNull(usuario)) {
	            return usuario;
	        } else {
	            return null; 
	        }
	        /*
	    } catch (Exception e) {
	        // Manejar la excepción si ocurre algún error
	        e.printStackTrace();
	        return null;
	    }
		*/
	}

	

}
