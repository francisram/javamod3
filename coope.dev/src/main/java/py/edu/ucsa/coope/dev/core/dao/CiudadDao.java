package py.edu.ucsa.coope.dev.core.dao;

import java.util.List;

import py.edu.ucsa.coope.dev.core.entities.Ciudad;
import py.edu.ucsa.coope.dev.web.dto.PaginadoDto;

public interface CiudadDao extends GenericDao<Integer, Ciudad> {

	public List<Ciudad>  getCiudadesByDepartamento(Integer idDepartamento);

	PaginadoDto<Ciudad> listar(int pagina ,int tamanioPagina ,String ordenarPor, String orden, String busqueda);
}
