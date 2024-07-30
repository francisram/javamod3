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
	public Iterable<ParticExpoSocio> obtenerParticipacionesPorSocio(Integer idSocio) {
		// TODO Auto-generated method stub
		return null;
	}



	
	
}
