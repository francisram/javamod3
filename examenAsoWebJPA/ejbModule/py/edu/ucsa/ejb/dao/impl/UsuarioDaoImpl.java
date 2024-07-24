package py.edu.ucsa.ejb.dao.impl;

import java.util.List;

import py.edu.ucsa.ejb.dao.UsuarioDao;
import py.edu.ucsa.ejb.entities.Rol;
import py.edu.ucsa.ejb.entities.Usuario;

public class UsuarioDaoImpl extends AbstractDao<Long, Usuario> implements UsuarioDao {

	@Override
	public List<Rol> getRolesByUsuario(Integer idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario validarUsuario(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Usuario> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Usuario findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Usuario insert(Usuario entity) {
		// TODO Auto-generated method stub
		return super.insert(entity);
	}

	@Override
	public Usuario update(Usuario entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}

	@Override
	public void delete(Usuario entity) {
		// TODO Auto-generated method stub
		super.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

}
