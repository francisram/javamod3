package py.edu.ucsa.ejb.dao.impl;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.Query;
import py.edu.ucsa.ejb.dao.IRolUsuarioDao;
import py.edu.ucsa.ejb.entities.Rol;
import py.edu.ucsa.ejb.entities.RolUsuario;
import py.edu.ucsa.ejb.entities.Usuario;

@RequestScoped
@Named("rolUsuarioDao")
public class RolUsuarioDaoImpl extends AbstractDao<Long, RolUsuario> implements IRolUsuarioDao {

	public RolUsuarioDaoImpl() {
		super(RolUsuario.class);
		// TODO Auto-generated constructor stub
	}

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

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Rol> getRolesByUsuario(Usuario usuario) {
		// TODO Auto-generated method stub

		Query q = this.entityManager.createNamedQuery("RolUsuario.getRolesByUsuario");
		q.setParameter("usuario", usuario);

		return q.getResultList();
	}

}
