package py.edu.ucsa.ejb.dao;

import py.edu.ucsa.ejb.entities.Equipo;

public interface IEquipoDao extends IGenericDao<Long, Equipo> {

	@Override
	default Iterable<Equipo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Equipo findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Equipo insert(Equipo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Equipo update(Equipo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default void delete(Equipo entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	default void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	public Iterable<Equipo> findAllByNombre(String nombre, boolean isNull);

}
