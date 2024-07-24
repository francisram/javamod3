package py.edu.ucsa.ejb.dao.impl;

import py.edu.ucsa.ejb.dao.RolDao;
import py.edu.ucsa.ejb.entities.Rol;

public class RolDaoImpl extends AbstractDao<Long, Rol>  implements RolDao{

	@Override
	public Iterable<Rol> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Rol findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Rol insert(Rol entity) {
		// TODO Auto-generated method stub
		return super.insert(entity);
	}

	@Override
	public Rol update(Rol entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}

	@Override
	public void delete(Rol entity) {
		// TODO Auto-generated method stub
		super.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

}
