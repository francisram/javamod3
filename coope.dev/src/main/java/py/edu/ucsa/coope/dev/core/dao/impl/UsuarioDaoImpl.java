package py.edu.ucsa.coope.dev.core.dao.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import py.edu.ucsa.coope.dev.core.dao.AbstractDao;
import py.edu.ucsa.coope.dev.core.dao.UsuarioDao;
import py.edu.ucsa.coope.dev.core.entities.Barrio;
import py.edu.ucsa.coope.dev.core.entities.Usuario;
import py.edu.ucsa.coope.dev.web.dto.PaginadoDto;
import py.edu.ucsa.coope.dev.web.dto.PaginationDto;

@Repository
public class UsuarioDaoImpl extends AbstractDao<Integer, Usuario> implements UsuarioDao {

	@Override
	public PaginadoDto<Usuario> listar(int pagina, int tamanioPagina, String ordenarPor, String orden,
			String busqueda) {
		String queryStr = "SELECT u FROM  Usuario u";
		queryStr += Objects.nonNull(busqueda) && !busqueda.isBlank() ? " WHERE UPPER(u.username) LIKE UPPER(:busqueda)" : "";
		queryStr += " ORDER BY d." + (Objects.nonNull(ordenarPor) && !ordenarPor.isBlank() ? ordenarPor : "id");
		queryStr += " " + (Objects.nonNull(orden) && !orden.isBlank() ? orden : "ASC");
		
		Query query = getEntityManager().createQuery(queryStr, Barrio.class);
		
		if (Objects.nonNull(busqueda) && !busqueda.isBlank()) {
			query.setParameter("busqueda", "%" + busqueda + "%");			
		}
		
		int total = query.getResultList().size();
		
		 query = getEntityManager().createQuery(queryStr, Barrio.class);
		
		if (Objects.nonNull(busqueda) && !busqueda.isBlank()) {
			query.setParameter("busqueda", "%" + busqueda + "%");			
		}
		query.setFirstResult(pagina * tamanioPagina);
		query.setMaxResults(tamanioPagina);
		
		@SuppressWarnings("unchecked")
		List<Usuario> resultados = query.getResultList();
		PaginadoDto<Usuario> paginado = new PaginadoDto<>();
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

	@Override
	public Optional<Usuario> findByUsuario(String usuario) {
		
		try {
			return Optional.of( (Usuario) this.getEntityManager().createNamedQuery("Usuario.findByUsuario").setParameter("username", usuario).getSingleResult());			
		} catch (NoResultException e) {
			return Optional.empty();
		}
		
	}

}
