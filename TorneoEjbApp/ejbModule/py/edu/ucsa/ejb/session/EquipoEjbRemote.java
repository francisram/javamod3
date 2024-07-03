package py.edu.ucsa.ejb.session;

import java.util.List;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.entities.Equipo;

@Remote
public interface EquipoEjbRemote extends GenericEjbRemote<Long ,Equipo> {

	@Override
	default List<Equipo> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default void insert(Equipo dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	default List<Equipo> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Equipo getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Equipo insertar(Equipo obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default void actualizar(Equipo obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	default void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

	public Equipo getByNombre(String nombre);

}
