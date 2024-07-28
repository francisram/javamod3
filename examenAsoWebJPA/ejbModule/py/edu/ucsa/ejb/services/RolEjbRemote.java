package py.edu.ucsa.ejb.services;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.dto.RolDTO;

@Remote
public interface RolEjbRemote extends GenericEjbRemote<Long, RolDTO> {

}
