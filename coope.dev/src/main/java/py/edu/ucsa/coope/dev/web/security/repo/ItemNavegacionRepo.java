package py.edu.ucsa.coope.dev.web.security.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import py.edu.ucsa.coope.dev.web.security.entities.ItemNavegacion;
import py.edu.ucsa.coope.dev.web.security.entities.OperacionesXItemNavegacion;

public interface ItemNavegacionRepo extends JpaRepository<ItemNavegacion, String>{
//	@Query("Select i from ItemNavegacionXPerfil i where i.perfil in ()")
	@Query(value="SELECT inav "
			+ "FROM ItemNavegacion inav, ItemNavegacionXPerfil inp, PerfilXUsuario pu "
			+ "WHERE pu.usuario.id = :idUsuario "
			+ "AND pu.perfil.id = inp.perfil.id "
			+ "AND inp.itemNavegacion.id = inav.id "
			+ "AND inp.estado.codigo = 'ACT'")
	Optional<List<ItemNavegacion>> findItemsNavByIdUsuario(@Param("idUsuario") Long idUsuario);
	
	@Query(value="SELECT new OperacionesXItemNavegacion(oin.id, oin.estado, oin.accion, oin.itemNavegacion) "
			+ "FROM OperacionesXItemNavegacion oin, ItemNavegacion inav, ItemNavegacionXPerfil inp, PerfilXUsuario pu, Opcion acc "
			+ "WHERE pu.usuario.id = :idUsuario "
			+ "AND pu.perfil.id = inp.perfil.id "
			+ "AND inp.itemNavegacion.id = inav.id "
			+ "AND oin.itemNavegacion.id = inav.id "
			+ "AND oin.accion.id = acc.id")
	Optional<List<OperacionesXItemNavegacion>> findOperacionesXItemNavByIdUsuario(@Param("idUsuario") Long idUsuario);
}
