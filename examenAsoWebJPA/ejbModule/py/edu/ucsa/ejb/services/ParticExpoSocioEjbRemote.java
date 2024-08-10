package py.edu.ucsa.ejb.services;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.dto.ParticExpoSocioDTO;
import py.edu.ucsa.ejb.entities.Exposicion;
import py.edu.ucsa.ejb.entities.ParticExpoSocio;
import py.edu.ucsa.ejb.entities.Socio;

@Remote
public interface ParticExpoSocioEjbRemote extends GenericEjbRemote<Long, ParticExpoSocioDTO> {

	public ParticExpoSocio ObtenerParticipacion(Exposicion expo, Socio socio);

	Iterable<ParticExpoSocio> obtenerParticipacionesPorSocio(Socio socio);
}
