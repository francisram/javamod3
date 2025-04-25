package py.edu.ucsa.coope.dev.core.dao;

import py.edu.ucsa.coope.dev.core.entities.Departamento;
import py.edu.ucsa.coope.dev.web.dto.PaginadoDto;

public interface DepartamentoDao extends GenericDao<Integer, Departamento> {
	PaginadoDto<Departamento> listar(int pagina ,int tamanioPagina ,String ordenarPor, String orden, String busqueda);
}
