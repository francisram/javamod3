package py.edu.ucsa.ejb.dao.impl;

import java.util.List;

import py.edu.ucsa.ejb.dao.IOpcionDao;
import py.edu.ucsa.ejb.entities.Opcion;

public class OpcionDaoImpl extends AbstractDao<Long, Opcion> implements IOpcionDao {
	

	public OpcionDaoImpl() {
		super(Opcion.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Opcion getOpcionByDominioCodOpcion(String dominio, String codOpcion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Opcion> getOpcionesByCodDominio(String dominio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Opcion> getOpcionesByIdDominio(Integer idDominio) {
		// TODO Auto-generated method stub
		return null;
	}

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
