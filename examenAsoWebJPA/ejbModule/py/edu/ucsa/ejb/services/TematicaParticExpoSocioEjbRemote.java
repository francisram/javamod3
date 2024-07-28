package py.edu.ucsa.ejb.services;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.dto.TematicaParticExpoSocioDTO;

@Remote
public interface TematicaParticExpoSocioEjbRemote extends GenericEjbRemote<Long, TematicaParticExpoSocioDTO> {

}
