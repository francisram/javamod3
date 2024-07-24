package py.edu.ucsa.ejb.dao.impl;

import py.edu.ucsa.ejb.dao.TematicaParticExpoSocioDao;
import py.edu.ucsa.ejb.entities.TematicaParticExpoSocio;

public class TematicaParticExpoSocioDaoImpl extends AbstractDao<Long, TematicaParticExpoSocio> implements TematicaParticExpoSocioDao {

	@Override
	public Iterable<TematicaParticExpoSocio> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public TematicaParticExpoSocio findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public TematicaParticExpoSocio insert(TematicaParticExpoSocio entity) {
		// TODO Auto-generated method stub
		return super.insert(entity);
	}

	@Override
	public TematicaParticExpoSocio update(TematicaParticExpoSocio entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}

	@Override
	public void delete(TematicaParticExpoSocio entity) {
		// TODO Auto-generated method stub
		super.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

}
