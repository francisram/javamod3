package py.edu.ucsa.ejb.dao.impl;

import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import py.edu.ucsa.ejb.dao.IUsuarioDao;
import py.edu.ucsa.ejb.dto.UsuarioDTO;

@RequestScoped
@Named("usuarioDAO")

public class UsuarioDaoImpl implements IUsuarioDao {
	
	@PersistenceContext(name = "TorneoJPA")
	protected EntityManager entityManager;
	
	protected EntityManager getEntityManager() {
		return this.entityManager;
	}

	@Override
	public UsuarioDTO validarUsuario(String username, String password) {
	
		
		//return this.entityManager.createQuery("SELECT u FROM UsuarioDTO u WHERE u.usuario = :usuario").setParameter("usuario", username).getResultList();
	
		  List<UsuarioDTO> usuarios = this.entityManager.createQuery(
			        "SELECT u FROM UsuarioDTO u WHERE u.usuario = :usuario AND u.password = :password", UsuarioDTO.class)
			        .setParameter("usuario", username)
			        .setParameter("password", password)
			        .getResultList();

			    if (usuarios.isEmpty()) {
			        return null; // o lanzar una excepción
			    }

			    return usuarios.get(0);
	}

	public UsuarioDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
