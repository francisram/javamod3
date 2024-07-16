package py.edu.ucsa.ejb.dao;


import py.edu.ucsa.ejb.entities.Equipo;
import py.edu.ucsa.ejb.entities.Jugador;

public interface IJugadorDao extends IGenericDao<Long, Jugador> {

	@Override
	default Iterable<Jugador> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Jugador findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Jugador insert(Jugador entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Jugador update(Jugador entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default void delete(Jugador entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	default void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	public Iterable<Jugador> findByNombre(String nombre, boolean isNull);
	public Iterable<Jugador> findJugadoresSinEquipo() ;
	public Iterable<Jugador> findJugadoresPorEquipo(Equipo e);
	
}
