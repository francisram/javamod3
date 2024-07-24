package py.edu.ucsa.ejb.dao.impl;

import py.edu.ucsa.ejb.dao.RolUsuarioDao;
import py.edu.ucsa.ejb.entities.RolUsuario;

public class RolUsuarioDaoImpl extends AbstractDao<Long, RolUsuario> implements RolUsuarioDao{

	@Override
	public Iterable<RolUsuario> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public RolUsuario findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public RolUsuario insert(RolUsuario entity) {
		// TODO Auto-generated method stub
		return super.insert(entity);
	}

	@Override
	public RolUsuario update(RolUsuario entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}

	@Override
	public void delete(RolUsuario entity) {
		// TODO Auto-generated method stub
		super.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

}
