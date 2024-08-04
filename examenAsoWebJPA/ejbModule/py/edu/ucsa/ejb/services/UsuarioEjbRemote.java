package py.edu.ucsa.ejb.services;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.dto.UsuarioDTO;
import py.edu.ucsa.ejb.entities.Rol;
import py.edu.ucsa.ejb.entities.Usuario;

@Remote
public interface UsuarioEjbRemote extends GenericEjbRemote<Long, UsuarioDTO>{
	
	Iterable<Rol> getRolesByUsuario(Integer idUsuario);
	
	public Usuario validarUsuario(String username, String password) ;

}
