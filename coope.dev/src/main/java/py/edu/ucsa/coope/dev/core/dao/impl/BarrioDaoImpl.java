package py.edu.ucsa.coope.dev.core.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import py.edu.ucsa.coope.dev.core.dao.AbstractDao;
import py.edu.ucsa.coope.dev.core.dao.BarrioDao;
import py.edu.ucsa.coope.dev.core.entities.Barrio;
import py.edu.ucsa.coope.dev.web.dto.PaginadoDto;

@Repository
public class BarrioDaoImpl extends AbstractDao<Integer, Barrio> implements BarrioDao{

	@SuppressWarnings("unchecked")
	public List<Barrio> getBarriosByIdCiudad(Integer idCiudad){
		return this.getEntityManager().createNamedQuery("Barrio.getBarriosByIdCiudad").setParameter("idCiudad", idCiudad).getResultList();
		
	}

	@Override
	public PaginadoDto<Barrio> listar(int pagina, int tamanioPagina, String ordenarPor, String orden, String busqueda) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
