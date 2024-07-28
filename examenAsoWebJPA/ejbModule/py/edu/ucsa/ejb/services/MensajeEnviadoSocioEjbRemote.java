package py.edu.ucsa.ejb.services;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.dto.MensajeEnviadoSocioDTO;

@Remote
public interface MensajeEnviadoSocioEjbRemote extends GenericEjbRemote<Long, MensajeEnviadoSocioDTO> {

}
