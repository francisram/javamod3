package py.edu.ucsa.ejb.dao.impl;

import py.edu.ucsa.ejb.dao.OpcionDao;
import py.edu.ucsa.ejb.entities.Opcion;

public class OpcionDaoImpl extends AbstractDao<Long, Opcion> implements OpcionDao {

	@Override
	public Iterable<Opcion> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Opcion findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Opcion insert(Opcion entity) {
		// TODO Auto-generated method stub
		return super.insert(entity);
	}

	@Override
	public Opcion update(Opcion entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}

	@Override
	public void delete(Opcion entity) {
		// TODO Auto-generated method stub
		super.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

}
