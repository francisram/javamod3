package py.edu.ucsa.coope.dev.core.dao.impl;

import java.util.List;

import py.edu.ucsa.coope.dev.core.dao.AbstractDao;
import py.edu.ucsa.coope.dev.core.dao.CiudadDao;
import py.edu.ucsa.coope.dev.core.entities.Ciudad;
import py.edu.ucsa.coope.dev.web.dto.PaginadoDto;

public class CiudadDaoImpl extends AbstractDao<Integer, Ciudad> implements CiudadDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Ciudad> getCiudadesByDepartamento(Integer idDepartamento) {
		return this.getEntityManager().createNamedQuery("Ciudad.getCiudadesByDepto").setParameter("idDepartamento", idDepartamento).getResultList();
	}

	@Override
	public PaginadoDto<Ciudad> listar(int pagina, int tamanioPagina, String ordenarPor, String orden, String busqueda) {
		// TODO Auto-generated method stub
		return null;
	}
}
