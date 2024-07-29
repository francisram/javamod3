package py.edu.ucsa.ejb.dao.impl;

import java.util.List;

import py.edu.ucsa.ejb.dao.IExposicionDao;
import py.edu.ucsa.ejb.entities.Exposicion;

public class ExposicionDaoImpl extends AbstractDao<Long, Exposicion> implements IExposicionDao {

	
	public ExposicionDaoImpl() {
		super(Exposicion.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Exposicion> listarPorFechas(String fechaInicial, String fechaFinal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Exposicion> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Exposicion findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Exposicion insert(Exposicion entity) {
		// TODO Auto-generated method stub
		return super.insert(entity);
	}

	@Override
	public Exposicion update(Exposicion entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}

	@Override
	public void delete(Exposicion entity) {
		// TODO Auto-generated method stub
		super.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

}
