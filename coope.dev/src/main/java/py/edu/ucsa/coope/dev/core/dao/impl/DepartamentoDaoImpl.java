package py.edu.ucsa.coope.dev.core.dao.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Repository;

import jakarta.persistence.Query;
import py.edu.ucsa.coope.dev.core.dao.AbstractDao;
import py.edu.ucsa.coope.dev.core.dao.DepartamentoDao;
import py.edu.ucsa.coope.dev.core.entities.Departamento;
import py.edu.ucsa.coope.dev.web.dto.PaginadoDto;
import py.edu.ucsa.coope.dev.web.dto.PaginationDto;

@Repository
public class DepartamentoDaoImpl extends AbstractDao<Integer, Departamento> implements DepartamentoDao{

	@Override
	public PaginadoDto<Departamento> listar(int pagina, int tamanioPagina, String ordenarPor, String orden,
			String busqueda) {
		String queryStr = "SELECT d FROM  Departamento d";
		queryStr += Objects.nonNull(busqueda) && !busqueda.isBlank() ? " WHERE UPPER(d.nombre) LIKE UPPER(:busqueda)" : "";
		queryStr += " ORDER BY d." + (Objects.nonNull(ordenarPor) && !ordenarPor.isBlank() ? ordenarPor : "id");
		queryStr += " " + (Objects.nonNull(orden) && !orden.isBlank() ? orden : "ASC");
		
		Query query = getEntityManager().createQuery(queryStr, Departamento.class);
		
		if (Objects.nonNull(busqueda) && !busqueda.isBlank()) {
			query.setParameter("busqueda", "%" + busqueda + "%");			
		}
		
		int total = query.getResultList().size();
		
		 query = getEntityManager().createQuery(queryStr,  Departamento.class);
		
		if (Objects.nonNull(busqueda) && !busqueda.isBlank()) {
			query.setParameter("busqueda", "%" + busqueda + "%");			
		}
		query.setFirstResult(pagina * tamanioPagina);
		query.setMaxResults(tamanioPagina);
		
		@SuppressWarnings("unchecked")
		List<Departamento> resultados = query.getResultList();
		PaginadoDto<Departamento> paginado = new PaginadoDto<>();
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
