package py.edu.ucsa.ejb.services;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.dto.ParticExpoSocioDTO;

@Remote
public interface ParticExpoSocioEjbRemote extends GenericEjbRemote<Long, ParticExpoSocioDTO> {

}
