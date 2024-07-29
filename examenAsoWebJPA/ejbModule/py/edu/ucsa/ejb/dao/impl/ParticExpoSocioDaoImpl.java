package py.edu.ucsa.ejb.dao.impl;

import java.util.List;

import py.edu.ucsa.ejb.dao.IParticExpoSocioDao;
import py.edu.ucsa.ejb.entities.ParticExpoSocio;

public class ParticExpoSocioDaoImpl extends AbstractDao<Long, ParticExpoSocio> implements IParticExpoSocioDao {

	
	public ParticExpoSocioDaoImpl() {
		super(ParticExpoSocio.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ParticExpoSocio ObtenerParticipacion(Integer id, Integer id_socio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ParticExpoSocio> obtenerParticipacionesPorSocio(Integer idSocio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<ParticExpoSocio> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public ParticExpoSocio findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public ParticExpoSocio insert(ParticExpoSocio entity) {
		// TODO Auto-generated method stub
		return super.insert(entity);
	}

	@Override
	public ParticExpoSocio update(ParticExpoSocio entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}

	@Override
	public void delete(ParticExpoSocio entity) {
		// TODO Auto-generated method stub
		super.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	
	
}
