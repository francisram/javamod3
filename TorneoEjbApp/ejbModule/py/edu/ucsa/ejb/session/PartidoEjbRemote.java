package py.edu.ucsa.ejb.session;

import java.util.List;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.entities.Partido;

@Remote
public interface PartidoEjbRemote extends GenericEjbRemote<Long ,Partido> {

	@Override
	default List<Partido> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default void insert(Partido dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	default List<Partido> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Partido getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Partido insertar(Partido obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default void actualizar(Partido obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	default void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}
	


}
