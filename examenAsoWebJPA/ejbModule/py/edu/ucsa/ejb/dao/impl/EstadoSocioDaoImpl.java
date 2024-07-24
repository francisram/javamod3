package py.edu.ucsa.ejb.dao.impl;

import py.edu.ucsa.ejb.dao.EstadoSocioDao;
import py.edu.ucsa.ejb.entities.EstadoSocio;

public class EstadoSocioDaoImpl extends AbstractDao<Long, EstadoSocio> implements EstadoSocioDao{

	@Override
	public Iterable<EstadoSocio> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public EstadoSocio findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public EstadoSocio insert(EstadoSocio entity) {
		// TODO Auto-generated method stub
		return super.insert(entity);
	}

	@Override
	public EstadoSocio update(EstadoSocio entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}

	@Override
	public void delete(EstadoSocio entity) {
		// TODO Auto-generated method stub
		super.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

}
