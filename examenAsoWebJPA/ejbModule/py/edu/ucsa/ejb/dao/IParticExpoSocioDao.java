package py.edu.ucsa.ejb.dao;

import java.util.List;

import py.edu.ucsa.ejb.entities.ParticExpoSocio;

public interface IParticExpoSocioDao extends IGenericDao<Long, ParticExpoSocio> {

	public ParticExpoSocio ObtenerParticipacion(Integer id, Integer id_socio);

	Iterable<ParticExpoSocio> obtenerParticipacionesPorSocio(Integer idSocio);

}