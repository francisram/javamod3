package py.edu.ucsa.ejb.dao;

import py.edu.ucsa.ejb.dto.UsuarioDTO;

public interface IUsuarioDao {
	public UsuarioDTO validarUsuario(String username, String password) ;
}
