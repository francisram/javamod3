package py.edu.ucsa.coope.dev.core.dao;

import java.util.Optional;

import py.edu.ucsa.coope.dev.web.dto.PaginadoDto;
import py.edu.ucsa.coope.dev.web.security.entities.Usuario;

public interface UsuarioDao extends GenericDao<Integer, Usuario> {

	PaginadoDto<Usuario> listar(int pagina ,int tamanioPagina ,String ordenarPor, String orden, String busqueda);
	Optional<Usuario> findByUsuario(String usuario);

}
