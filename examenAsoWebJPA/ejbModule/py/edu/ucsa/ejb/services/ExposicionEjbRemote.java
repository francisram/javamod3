package py.edu.ucsa.ejb.services;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.dto.ExposicionDTO;

@Remote
public interface ExposicionEjbRemote extends GenericEjbRemote<Long, ExposicionDTO> {

}
