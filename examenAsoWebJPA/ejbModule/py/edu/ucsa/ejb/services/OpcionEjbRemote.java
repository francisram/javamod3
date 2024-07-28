package py.edu.ucsa.ejb.services;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.dto.OpcionDTO;

@Remote
public interface OpcionEjbRemote extends GenericEjbRemote<Long, OpcionDTO> {

}
