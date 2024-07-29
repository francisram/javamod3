package py.edu.ucsa.ejb.dao.impl;

import py.edu.ucsa.ejb.dao.IMontoCuotaDao;
import py.edu.ucsa.ejb.entities.MontoCuota;

public class MontoCuotaDaoImpl extends AbstractDao<Long, MontoCuota> implements IMontoCuotaDao {

	
	public MontoCuotaDaoImpl() {
		super(MontoCuota.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Iterable<MontoCuota> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public MontoCuota getMontoCuotaByAnho(int mes, int anho) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MontoCuota findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public MontoCuota insert(MontoCuota entity) {
		// TODO Auto-generated method stub
		return super.insert(entity);
	}

	@Override
	public MontoCuota update(MontoCuota entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}

	@Override
	public void delete(MontoCuota entity) {
		// TODO Auto-generated method stub
		super.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

}
