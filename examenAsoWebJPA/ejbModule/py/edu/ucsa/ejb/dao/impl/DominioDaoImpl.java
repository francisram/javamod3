package py.edu.ucsa.ejb.dao.impl;

import py.edu.ucsa.ejb.dao.DominioDao;
import py.edu.ucsa.ejb.entities.Dominio;

public class DominioDaoImpl extends AbstractDao<Long, Dominio> implements DominioDao {

	@Override
	public Iterable<Dominio> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Dominio findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Dominio insert(Dominio entity) {
		// TODO Auto-generated method stub
		return super.insert(entity);
	}

	@Override
	public Dominio update(Dominio entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}

	@Override
	public void delete(Dominio entity) {
		// TODO Auto-generated method stub
		super.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

}
