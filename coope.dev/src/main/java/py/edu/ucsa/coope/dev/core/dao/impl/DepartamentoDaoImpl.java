package py.edu.ucsa.coope.dev.core.dao.impl;

import py.edu.ucsa.coope.dev.core.dao.AbstractDao;
import py.edu.ucsa.coope.dev.core.dao.DepartamentoDao;
import py.edu.ucsa.coope.dev.core.entities.Departamento;
import py.edu.ucsa.coope.dev.web.dto.PaginadoDto;

public class DepartamentoDaoImpl extends AbstractDao<Integer, Departamento> implements DepartamentoDao{

	@Override
	public PaginadoDto<Departamento> listar(int pagina, int tamanioPagina, String ordenarPor, String orden,
			String busqueda) {
		return null;
	}

}
