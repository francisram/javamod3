package py.edu.ucsa.ejb.dao;

import py.edu.ucsa.ejb.entities.Exposicion;
import py.edu.ucsa.ejb.entities.ParticExpoSocio;
import py.edu.ucsa.ejb.entities.Socio;

public interface IParticExpoSocioDao extends IGenericDao<Long, ParticExpoSocio> {

	public ParticExpoSocio ObtenerParticipacion(Exposicion exposicion, Socio socio);

	Iterable<ParticExpoSocio> obtenerParticipacionesPorSocio(Socio idSocio);

}
