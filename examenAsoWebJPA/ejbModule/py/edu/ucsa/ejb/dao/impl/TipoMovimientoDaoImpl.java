package py.edu.ucsa.ejb.dao.impl;

import py.edu.ucsa.ejb.dao.TipoMovimientoDao;
import py.edu.ucsa.ejb.entities.TipoMovimiento;

public class TipoMovimientoDaoImpl extends AbstractDao<Long, TipoMovimiento> implements TipoMovimientoDao {

	@Override
	public Iterable<TipoMovimiento> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public TipoMovimiento findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public TipoMovimiento insert(TipoMovimiento entity) {
		// TODO Auto-generated method stub
		return super.insert(entity);
	}

	@Override
	public TipoMovimiento update(TipoMovimiento entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}

	@Override
	public void delete(TipoMovimiento entity) {
		// TODO Auto-generated method stub
		super.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

}
