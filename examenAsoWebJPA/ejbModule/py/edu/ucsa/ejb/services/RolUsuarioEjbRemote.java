package py.edu.ucsa.ejb.services;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.dto.RolUsuarioDTO;
import py.edu.ucsa.ejb.entities.Rol;
import py.edu.ucsa.ejb.entities.RolUsuario;
import py.edu.ucsa.ejb.entities.Usuario;

@Remote
public interface RolUsuarioEjbRemote extends GenericEjbRemote<Long, RolUsuarioDTO>{

	
	Iterable<RolUsuario> getRolesByUsuario(Usuario idUsuario);
}
