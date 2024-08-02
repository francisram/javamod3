package py.edu.ucsa.ejb.services;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.dto.ParticExpoSocioDTO;
import py.edu.ucsa.ejb.entities.ParticExpoSocio;

@Remote
public interface ParticExpoSocioEjbRemote extends GenericEjbRemote<Long, ParticExpoSocioDTO> {

	public ParticExpoSocio ObtenerParticipacion(Integer id, Integer id_socio);

	Iterable<ParticExpoSocio> obtenerParticipacionesPorSocio(Integer idSocio);
}
