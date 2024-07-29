package py.edu.ucsa.ejb.dao.impl;

import py.edu.ucsa.ejb.dao.IPagoCuotaSocioDao;
import py.edu.ucsa.ejb.entities.PagoCuotaSocio;

public class PagoCuotaSocioDaoImpl extends AbstractDao<Long, PagoCuotaSocio> implements IPagoCuotaSocioDao {

	
	public PagoCuotaSocioDaoImpl() {
		super(PagoCuotaSocio.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Iterable<PagoCuotaSocio> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public PagoCuotaSocio findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public PagoCuotaSocio insert(PagoCuotaSocio entity) {
		// TODO Auto-generated method stub
		return super.insert(entity);
	}

	@Override
	public PagoCuotaSocio update(PagoCuotaSocio entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}

	@Override
	public void delete(PagoCuotaSocio entity) {
		// TODO Auto-generated method stub
		super.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

}
