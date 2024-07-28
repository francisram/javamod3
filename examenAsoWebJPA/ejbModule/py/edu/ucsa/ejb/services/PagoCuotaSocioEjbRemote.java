package py.edu.ucsa.ejb.services;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.dto.PagoCuotaSocioDTO;

@Remote
public interface PagoCuotaSocioEjbRemote extends GenericEjbRemote<Long, PagoCuotaSocioDTO> {

}
