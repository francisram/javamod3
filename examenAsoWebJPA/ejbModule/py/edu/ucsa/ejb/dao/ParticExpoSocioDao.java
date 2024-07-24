package py.edu.ucsa.ejb.dao;

import java.util.List;

import py.edu.ucsa.ejb.entities.ParticExpoSocio;

public interface ParticExpoSocioDao extends IGenericDao<Long, ParticExpoSocio> {

	public ParticExpoSocio ObtenerParticipacion(Integer id, Integer id_socio);

	List<ParticExpoSocio> obtenerParticipacionesPorSocio(Integer idSocio);

}
