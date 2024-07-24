package py.edu.ucsa.ejb.dao.impl;

import py.edu.ucsa.ejb.dao.MensajeEnviadoSocioDao;
import py.edu.ucsa.ejb.entities.MensajeEnviadoSocio;

public class MensajeEnviadoSocioDaoImpl extends AbstractDao<Long, MensajeEnviadoSocio> implements MensajeEnviadoSocioDao{

	@Override
	public Iterable<MensajeEnviadoSocio> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public MensajeEnviadoSocio findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public MensajeEnviadoSocio insert(MensajeEnviadoSocio entity) {
		// TODO Auto-generated method stub
		return super.insert(entity);
	}

	@Override
	public MensajeEnviadoSocio update(MensajeEnviadoSocio entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}

	@Override
	public void delete(MensajeEnviadoSocio entity) {
		// TODO Auto-generated method stub
		super.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

}
