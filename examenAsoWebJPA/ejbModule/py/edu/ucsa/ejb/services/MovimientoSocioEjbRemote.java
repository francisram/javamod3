package py.edu.ucsa.ejb.services;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.dto.MovimientoSocioDTO;

@Remote
public interface MovimientoSocioEjbRemote extends GenericEjbRemote<Long, MovimientoSocioDTO> {

}
