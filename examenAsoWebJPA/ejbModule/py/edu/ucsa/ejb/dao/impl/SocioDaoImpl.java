package py.edu.ucsa.ejb.dao.impl;

import py.edu.ucsa.ejb.dao.ISocioDao;
import py.edu.ucsa.ejb.entities.Socio;

public class SocioDaoImpl extends AbstractDao<Long, Socio>  implements ISocioDao{

	
	
	public SocioDaoImpl() {
		super(Socio.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Socio getSocioByNroCedula(String nroCedula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Socio> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Socio findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Socio insert(Socio entity) {
		// TODO Auto-generated method stub
		return super.insert(entity);
	}

	@Override
	public Socio update(Socio entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}

	@Override
	public void delete(Socio entity) {
		// TODO Auto-generated method stub
		super.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

}
