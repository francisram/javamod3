package py.edu.ucsa.ejb.dao.impl;

import py.edu.ucsa.ejb.dao.IMovimientoSocioDao;
import py.edu.ucsa.ejb.entities.MovimientoSocio;

public class MovimientoSocioDaoImpl extends AbstractDao<Long, MovimientoSocio> implements IMovimientoSocioDao {

	
	public MovimientoSocioDaoImpl() {
		super(MovimientoSocio.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Iterable<MovimientoSocio> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public MovimientoSocio findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public MovimientoSocio insert(MovimientoSocio entity) {
		// TODO Auto-generated method stub
		return super.insert(entity);
	}

	@Override
	public MovimientoSocio update(MovimientoSocio entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}

	@Override
	public void delete(MovimientoSocio entity) {
		// TODO Auto-generated method stub
		super.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

}
