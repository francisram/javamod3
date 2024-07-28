package py.edu.ucsa.ejb.services;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.dto.EstadoSocioDTO;

@Remote
public interface EstadoSocioEjbRemote extends GenericEjbRemote<Long, EstadoSocioDTO> {

}
