package py.edu.ucsa.coope.dev.core.dao;

import java.util.List;

import py.edu.ucsa.coope.dev.core.entities.Barrio;
import py.edu.ucsa.coope.dev.web.dto.PaginadoDto;



public interface BarrioDao extends GenericDao<Integer, Barrio> {
	public List<Barrio> getBarriosByIdCiudad(Integer idCiudad);
	PaginadoDto<Barrio> listar(int pagina ,int tamanioPagina ,String ordenarPor, String orden, String busqueda);
}
