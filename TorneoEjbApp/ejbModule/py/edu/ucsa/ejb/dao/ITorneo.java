package py.edu.ucsa.ejb.dao;

import py.edu.ucsa.ejb.entities.Equipo;
import py.edu.ucsa.ejb.entities.Torneo;

public interface ITorneo extends IGenericDao<Long, Torneo> {

	@Override
	default Iterable<Torneo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Torneo findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Torneo insert(Torneo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Torneo update(Torneo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default void delete(Torneo entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	default void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	public Iterable<Equipo> findByAnho(int anho);

}
