package py.edu.ucsa.ejb.services;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.dto.UsuarioDTO;

@Remote
public interface UsuarioEjbRemote {
	
	public UsuarioDTO validarUsuario(String username, String password) ;

}
