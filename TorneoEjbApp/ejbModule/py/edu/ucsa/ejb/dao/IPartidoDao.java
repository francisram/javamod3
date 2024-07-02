package py.edu.ucsa.ejb.dao;

import py.edu.ucsa.ejb.entities.Equipo;
import py.edu.ucsa.ejb.entities.Partido;

public interface IPartidoDao  extends IGenericDao<Long, Partido>{

	@Override
	default Iterable<Partido> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Partido findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Partido insert(Partido entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Partido update(Partido entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default void delete(Partido entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	default void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	public Iterable<Partido> findByFechaNro(int fechaNro);
	
}
