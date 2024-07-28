package py.edu.ucsa.ejb.services;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.dto.DominioDTO;

@Remote
public interface DominioEjbRemote extends GenericEjbRemote<Long, DominioDTO> {

}
