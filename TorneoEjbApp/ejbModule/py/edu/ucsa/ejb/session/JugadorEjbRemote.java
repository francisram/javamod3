package py.edu.ucsa.ejb.session;

import java.util.List;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.entities.Jugador;

@Remote
public interface JugadorEjbRemote extends GenericEjbRemote<Long ,Jugador>{
	
	public Jugador getByNombre(String nombre);

	@Override
	default List<Jugador> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default void insert(Jugador dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	default List<Jugador> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Jugador getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Jugador insertar(Jugador obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default void actualizar(Jugador obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	default void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
