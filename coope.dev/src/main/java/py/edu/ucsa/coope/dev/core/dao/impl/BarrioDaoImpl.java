package py.edu.ucsa.coope.dev.core.dao.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Repository;

import jakarta.persistence.Query;
import py.edu.ucsa.coope.dev.core.dao.AbstractDao;
import py.edu.ucsa.coope.dev.core.dao.BarrioDao;
import py.edu.ucsa.coope.dev.core.entities.Barrio;
import py.edu.ucsa.coope.dev.web.dto.PaginadoDto;
import py.edu.ucsa.coope.dev.web.dto.PaginationDto;

@Repository
public class BarrioDaoImpl extends AbstractDao<Integer, Barrio> implements BarrioDao{
	
	private  String queryStr = "SELECT b.* FROM  barrios b";

	@SuppressWarnings("unchecked")
	public List<Barrio> getBarriosByIdCiudad(Integer idCiudad){
		return this.getEntityManager().createNamedQuery("Barrio.getBarriosByIdCiudad").setParameter("idCiudad", idCiudad).getResultList();
		
	}

	@Override
	public PaginadoDto<Barrio> listar(int pagina, int tamanioPagina, String ordenarPor, String orden, String busqueda) {
		
		queryStr += Objects.nonNull(busqueda) && !busqueda.isBlank() ? " WHERE d.timbrado LIKE :timbrado" : "";
		queryStr += " ORDER BY b." + (Objects.nonNull(ordenarPor) && !ordenarPor.isBlank() ? ordenarPor : "id");
		queryStr += " " + (Objects.nonNull(orden) && !orden.isBlank() ? orden : "ASC");
		
		Query query = getEntityManager().createQuery(queryStr, Barrio.class);
		
		int total = query.getResultList().size();
		query.setFirstResult(pagina * tamanioPagina);
		query.setMaxResults(tamanioPagina);
		
		@SuppressWarnings("unchecked")
		List<Barrio> resultados = query.getResultList();
		PaginadoDto<Barrio> paginado = new PaginadoDto<>();
		paginado.setData(resultados);
		
		PaginationDto p = new PaginationDto();
		p.setLength(total);
		p.setSize(tamanioPagina);
		p.setPage(pagina);
		p.setLastPage((int) Math.ceil((double) total / tamanioPagina));
		p.setStartIndex(pagina * tamanioPagina);
		p.setEndIndex(p.getStartIndex() + (tamanioPagina-1));
		paginado.setPagination(p);
		return paginado;
		
	
	}
	
}
