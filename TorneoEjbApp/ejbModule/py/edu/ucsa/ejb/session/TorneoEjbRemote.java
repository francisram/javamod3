package py.edu.ucsa.ejb.session;

import java.util.List;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.entities.Torneo;

@Remote
public interface TorneoEjbRemote extends GenericEjbRemote<Long , Torneo>{
	public Torneo getByNombre (String nombre);

	@Override
	default List<Torneo> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default void insert(Torneo dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	default List<Torneo> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Torneo getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Torneo insertar(Torneo obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default void actualizar(Torneo obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	default void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
