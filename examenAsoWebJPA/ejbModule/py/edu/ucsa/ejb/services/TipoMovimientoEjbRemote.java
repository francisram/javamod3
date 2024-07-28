package py.edu.ucsa.ejb.services;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.dto.TipoMovimientoDTO;

@Remote
public interface TipoMovimientoEjbRemote extends GenericEjbRemote<Long, TipoMovimientoDTO> {

}
