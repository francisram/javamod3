package py.edu.ucsa.ejb.dao;

import java.util.List;

import py.edu.ucsa.ejb.entities.Rol;
import py.edu.ucsa.ejb.entities.Usuario;

public interface IUsuarioDao extends IGenericDao<Long, Usuario> {
	
	Iterable<Rol> getRolesByUsuario(Integer idUsuario);
	
	public Usuario validarUsuario(String username, String password) ;


}
