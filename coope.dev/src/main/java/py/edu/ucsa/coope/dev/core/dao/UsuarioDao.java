package py.edu.ucsa.coope.dev.core.dao;

import java.util.List;


import py.edu.ucsa.coope.dev.core.entities.Usuario;
import py.edu.ucsa.coope.dev.web.dto.PaginadoDto;

public interface UsuarioDao extends GenericDao<Integer, Usuario> {

	PaginadoDto<Usuario> listar(int pagina ,int tamanioPagina ,String ordenarPor, String orden, String busqueda);

}
